package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;
import com.todo.list.repository.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class TarefaServiceTest {

    @InjectMocks
    private TarefaServiceImpl tarefaService ;

    @Mock
    private TarefaRepository tarefaRepository;

    @Test
    public void criarTarefaDeveCriarTarefaComStatusIniciadaQuandoCensarioSucesso(){
        Tarefa tarefa = new Tarefa(1L ,TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Projet TDD");
        Mockito.when(tarefaRepository.save(any())).thenReturn(tarefa);

        TarefaRequestDTO requestDTO = new TarefaRequestDTO("Aprender DTO", "Estrutura Projeto");
        TarefaResponseDTO tarefaResponseDTO = tarefaService.criarTarefa(requestDTO);

        Assertions.assertNotNull(tarefaResponseDTO.getId());
        Assertions.assertEquals(tarefaResponseDTO.getName(), tarefa.getName());
        Assertions.assertEquals(tarefaResponseDTO.getDescription(), tarefa.getDescription());
        Assertions.assertNotNull(tarefaResponseDTO.getCreatedAt());
        Assertions.assertEquals(TarefaStatus.CRIADA, tarefaResponseDTO.getTarefaStatus());


    }
}
