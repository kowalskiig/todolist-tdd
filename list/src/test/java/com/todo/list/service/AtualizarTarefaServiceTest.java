package com.todo.list.service;

import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;
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




    @BeforeEach
    void setUp(){




    }

    @Test
    public void atualizarEstadoTarefaParaEmAndamentoDeveriaAtualizarEstadoQuandoEstadoTarefaÉCriada(){

        Long idExistenteTarefa = 1L;
        Tarefa tarefaCriada = new Tarefa(1L , TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Projet TDD");

        Mockito.when(tarefaRepository.findById(idExistenteTarefa))
                .thenReturn(Optional.of(tarefaCriada));
        Mockito.when(tarefaRepository.save(any()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        //acao

        TarefaResponseDTO tarefaResponseDTO = tarefaService
                .atualizarEstadoParaEmAndamento(idExistenteTarefa);

        //validacao

        Assertions.assertEquals(TarefaStatus.EM_ANDAMENTO,tarefaResponseDTO.getTarefaStatus());
    }


    @Test
    public void atualizarEstadoParaEmAndamento_DeveLancarExcecao_QuandoIdNaoExiste(){
        Long idInexistente =1L;

        Mockito.when(tarefaRepository.findById(idInexistente))
                .thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {

            tarefaService
                    .atualizarEstadoParaEmAndamento(idInexistente);
        });

    }
}
