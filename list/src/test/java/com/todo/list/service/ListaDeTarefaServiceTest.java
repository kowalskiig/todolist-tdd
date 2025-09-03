package com.todo.list.service;

import com.todo.list.dto.RequestListaDeTarefa;
import com.todo.list.dto.RespondeListaDeTarefa;
import com.todo.list.entity.Tarefa;
import com.todo.list.entity.ListaDeTarefa;
import com.todo.list.enums.TarefaStatus;
import com.todo.list.repository.ListaDeTarefaRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class ListaDeTarefaServiceTest {

    @InjectMocks
    private ListaDeTarefaService listaDeTarefaService;

    @Mock
    private ListaDeTarefaRepository listaDeTarefaRepository;



    private ListaDeTarefa listaDeTarefa;
    private List<Tarefa> listaDeTarefas;
    private Tarefa tarefa;

    @BeforeEach
    void setUp(){


        tarefa = new Tarefa(1L , TarefaStatus.CRIADA, "Estrutura Projeto", Instant.now(), "Nome");
        listaDeTarefas = new ArrayList<>();
        listaDeTarefa = new ListaDeTarefa(1L, "Nome");
        Mockito.when(listaDeTarefaRepository.save(any())).thenReturn(listaDeTarefa);
    }

    @Test
    public void AdicionaListaDeTarefaDeveRetornarListaDeTarefaCriadaQuandoSucesso(){
        RequestListaDeTarefa requestListaDeTarefa = new RequestListaDeTarefa("Nome");

        RespondeListaDeTarefa result = listaDeTarefaService.criarTarefa(requestListaDeTarefa);

        Assertions.assertNotNull(result.getId());
        Assertions.assertEquals(tarefa.getName(), result.getName());
        Assertions.assertEquals(0 ,result.getTarefas().size());
    }
}
