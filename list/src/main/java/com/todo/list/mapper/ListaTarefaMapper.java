package com.todo.list.mapper;

import com.todo.list.dto.RequestListaDeTarefa;
import com.todo.list.dto.RespondeListaDeTarefa;
import com.todo.list.entity.ListaDeTarefa;

public class ListaTarefaMapper {

    private static RespondeListaDeTarefa toDto(ListaDeTarefa listaDeTarefa){
        return new RespondeListaDeTarefa(listaDeTarefa.getId(),
                                        listaDeTarefa.getTarefas().stream().map(TarefaMapper::tarefaParaDto).toList(),
                                        listaDeTarefa.getName());
    }

    private static ListaDeTarefa toEntity(RequestListaDeTarefa requestListaDeTarefa){
        return new ListaDeTarefa(null, requestListaDeTarefa.getName());
    }
}
