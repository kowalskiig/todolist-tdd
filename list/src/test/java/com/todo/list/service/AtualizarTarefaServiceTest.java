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


    private Long idExistenteTarefaCriada, idInexistente, idExistenteTarefaComStatusEmAndamento, idExistenteTarefa5MinutosAntes;

    private Tarefa tarefaStatusCriada,tarefaComStatusEmAndamento, tarefaStatusEmAndamentoCom5MinutosInvalido;


    @BeforeEach
    void setUp(){

    idExistenteTarefaCriada =1L;
    idInexistente=2L;
    idExistenteTarefaComStatusEmAndamento=3L;
    idExistenteTarefa5MinutosAntes=4L;


    tarefaStatusCriada = new Tarefa(1L , TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Projet TDD");

    tarefaComStatusEmAndamento = new Tarefa(1L , TarefaStatus.EM_ANDAMENTO, "Estrutura Projeto", Instant.now(), "Projet TDD");

        tarefaStatusEmAndamentoCom5MinutosInvalido = new Tarefa(1L, TarefaStatus.EM_ANDAMENTO, "Teste 5 minutos", Instant.now().minusSeconds(240), "Teste 5 Minutos");

    Mockito.when(tarefaRepository.findById(idExistenteTarefaCriada))
                .thenReturn(Optional.of(tarefaStatusCriada));

    Mockito.when(tarefaRepository.findById(idInexistente))
                .thenReturn(Optional.empty());

    Mockito.when(tarefaRepository.findById(idExistenteTarefaComStatusEmAndamento))
                .thenReturn(Optional.of(tarefaComStatusEmAndamento));

        Mockito.when(tarefaRepository.findById(idExistenteTarefa5MinutosAntes))
                .thenReturn(Optional.of(tarefaStatusEmAndamentoCom5MinutosInvalido));



    Mockito.when(tarefaRepository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Mockito.when(tarefaRepository.existeTarefaEmAndamento())
                .thenReturn(false);

    }

    @Test
    public void atualizarEstadoTarefaParaEmAndamentoDeveriaAtualizarEstadoQuandoEstadoTarefaÉCriada(){

        //acao

        TarefaResponseDTO tarefaResponseDTO = tarefaService
                .atualizarEstadoParaEmAndamento(idExistenteTarefaCriada);

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
                    .atualizarEstadoParaEmAndamento(idExistenteTarefaCriada);
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

    @Test
    public void finalizarTarefaDeveRetornarUnprocessableEntityExceptionStatusTarefaForDiferentedDeEmAndamento(){

        UnprocessableEntity exception = Assertions.assertThrows(UnprocessableEntity.class, () -> {
            tarefaService
                    .finalizarTarefa(idExistenteTarefaCriada);
        });
        Assertions.assertEquals("O status da tarefa tem que ser (EM ANDAMENTO)", exception.getMessage());
    }

    @Test
    public void finalizarTarefaDeveRetornarUnprocessableEntityExceptionQuandoTempoForMenorQue5Minutos(){
        UnprocessableEntity exception = Assertions.assertThrows(UnprocessableEntity.class, () -> {
            tarefaService
                    .finalizarTarefa(idExistenteTarefa5MinutosAntes);
        });
        Assertions.assertEquals("Só é possivel finalizar uma tarefa que está em andamento a no minimo 5 minutos", exception.getMessage());
    }



}
