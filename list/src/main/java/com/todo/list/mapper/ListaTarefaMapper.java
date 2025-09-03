package com.todo.list.mapper;

import com.todo.list.dto.RequestListaDeTarefa;
import com.todo.list.dto.ResponseListaDeTarefa;
import com.todo.list.entity.ListaDeTarefa;

public class ListaTarefaMapper {

    public static ResponseListaDeTarefa toDto(ListaDeTarefa listaDeTarefa){
        return new ResponseListaDeTarefa(listaDeTarefa.getId(),
                                        listaDeTarefa.getTarefas().stream().map(TarefaMapper::tarefaParaDto).toList(),
                                        listaDeTarefa.getName());
    }

    public static ListaDeTarefa toEntity(RequestListaDeTarefa requestListaDeTarefa){
        return new ListaDeTarefa(null, requestListaDeTarefa.getName());
    }
}
