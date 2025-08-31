package com.todo.list.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;

public class TarefaServiceTest {

    @InjectMocks
    private TarefaServiceContrato tarefaServiceContrato;

    @Mock
    private TarefaRepository tarefaRepository;



    @Test
    public void criarTarefaDeveCriarTarefaComStatusIniciadaQuandoCensarioSucesso(){
        Tarefa tarefa = new Tarefa(1L ,"Aprender DTO", "Estrutura Projeto", Instant.now(), TarefaStatus.CRIADO);
        Mockito.when(tarefaRepository.save(any())).thenReturn(tarefa);

        TarefaRequeestDTO requeestDTO = new TarefaRequestDTO("Aprender DTO", "Estrutura Projeto");
        TarefaResponseDTO tarefaResponseDTO = tarefaServiceContrato.criarTarefa(requeestDTO);

        Assertions.assertNotNull(tarefaResponseDTO.getId());
        Assertions.assertEquals(tarefaResponseDTO.getTitle(), requeestDTO.getTitle());
        Assertions.assertEquals(tarefaResponseDTO.getDescription(), requeestDTO.getDescription());
        Assertions.assertEquals("CRIADA", tarefaResponseDTO.getStatusTarefa());


    }
}
