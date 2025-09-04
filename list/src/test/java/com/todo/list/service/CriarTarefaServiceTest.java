package com.todo.list.service;

import com.todo.list.dto.TarefaRequestDTO;
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

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class CriarTarefaServiceTest {

    @InjectMocks
    private TarefaServiceImpl tarefaService ;

    @Mock
    private TarefaRepository tarefaRepository;

    private Tarefa tarefaCriada;

    private TarefaRequestDTO tarefaRequestDTOComDados;

    private Long idListaDeTarefaExistente;


    @BeforeEach
    void setUP(){
        idListaDeTarefaExistente = 2L;

        tarefaCriada = new Tarefa(1L ,TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Projet TDD");
        tarefaRequestDTOComDados = new TarefaRequestDTO("Aprender DTO", "Estrutura Projeto");

        Mockito.when(tarefaRepository.save(any())).thenReturn(tarefaCriada);


    }

    @Test
    public void criarTarefaDeveCriarTarefaComStatusIniciadaQuandoCenarioSucesso(){

        TarefaResponseDTO tarefaResponseDTO = tarefaService.criarTarefa(tarefaRequestDTOComDados);


        Assertions.assertNotNull(tarefaResponseDTO.getId());
        Assertions.assertEquals(tarefaResponseDTO.getName(), tarefaCriada.getName());
        Assertions.assertEquals(tarefaResponseDTO.getDescription(), tarefaCriada.getDescription());
        Assertions.assertNotNull(tarefaResponseDTO.getCreatedAt());
        Assertions.assertEquals(TarefaStatus.CRIADA, tarefaResponseDTO.getTarefaStatus());


    }


}
