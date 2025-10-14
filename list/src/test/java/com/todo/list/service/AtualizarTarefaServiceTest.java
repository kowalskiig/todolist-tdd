package com.todo.list.service;

import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;
import com.todo.list.exceptions.ResourceNotFoundException;
import com.todo.list.exceptions.UnprocessableEntity;
import com.todo.list.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class AtualizarTarefaServiceTest {

    @InjectMocks
    private TarefaServiceImpl tarefaService ;

    @Mock
    private TarefaRepository tarefaRepository;


    private Long idExistenteTarefa, idInexistente, idExistenteTarefaComStatusEmAndamento;

    private Tarefa tarefaStatusCriada,tarefaComStatusEmAndamento;


    @BeforeEach
    void setUp(){

    idExistenteTarefa =1L;
    idInexistente=2L;
    idExistenteTarefaComStatusEmAndamento=3L;


    tarefaStatusCriada = new Tarefa(1L , TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Projet TDD");

    tarefaComStatusEmAndamento = new Tarefa(1L , TarefaStatus.EM_ANDAMENTO, "Estrutura Projeto", Instant.now(), "Projet TDD");


    Mockito.when(tarefaRepository.findById(idExistenteTarefa))
                .thenReturn(Optional.of(tarefaStatusCriada));

    Mockito.when(tarefaRepository.findById(idInexistente))
                .thenReturn(Optional.empty());

    Mockito.when(tarefaRepository.findById(idExistenteTarefaComStatusEmAndamento))
                .thenReturn(Optional.of(tarefaComStatusEmAndamento));



    Mockito.when(tarefaRepository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Mockito.when(tarefaRepository.existeTarefaEmAndamento())
                .thenReturn(false);

    }

    @Test
    public void atualizarEstadoTarefaParaEmAndamentoDeveriaAtualizarEstadoQuandoEstadoTarefaÉCriada(){

        //acao

        TarefaResponseDTO tarefaResponseDTO = tarefaService
                .atualizarEstadoParaEmAndamento(idExistenteTarefa);

        //validacao

        Assertions.assertEquals(TarefaStatus.EM_ANDAMENTO,tarefaResponseDTO.getTarefaStatus());
    }


    @Test
    public void atualizarEstadoParaEmAndamentoDeveLancarResourceNotFoundExceptionQuandoIdNaoExiste(){

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {

            tarefaService
                    .atualizarEstadoParaEmAndamento(idInexistente);
        });

    }

    @Test
    public void atualizarEstadoParaEmAndamentoDeveLancarUnprocessableEntityQuandoEstadoDiferenteDeCriada(){

        Assertions.assertThrows(UnprocessableEntity.class, () -> {

            tarefaService
                    .atualizarEstadoParaEmAndamento(idExistenteTarefaComStatusEmAndamento);
        });
    }

    @Test
    public void atualizarEstadoParaEmAndamentoDeveLancarUnprocessableEntityQuandoExisteTarefaEmAndamento(){

        Mockito.when(tarefaRepository.existeTarefaEmAndamento())
                .thenReturn(true);

        Assertions.assertThrows(UnprocessableEntity.class, () -> {
            tarefaService
                    .atualizarEstadoParaEmAndamento(idExistenteTarefa);
        });
    }

    @Test
    public void finalizarTarefaDeveRetornarResourceNotFoundExceptionQuandoIdNaoExistir(){


        ResourceNotFoundException exception = Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            tarefaService
                    .finalizarTarefa(idInexistente);
        });
        Assertions.assertEquals("Id inexistente", exception.getMessage());
    }



}
