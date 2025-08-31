package com.todo.list.mapper;

import com.todo.list.dto.TarefaRequestDTO;
import com.todo.list.dto.TarefaResponseDTO;
import com.todo.list.entity.Tarefa;


public class TarefaMapper {

    public static Tarefa dtoParaTarefa(TarefaRequestDTO tarefaRequestDTO){
        return new Tarefa(
                tarefaRequestDTO.getName(),
                tarefaRequestDTO.getDescription());
    }

    public static TarefaResponseDTO tarefaParaDto(Tarefa tarefa){
        return new TarefaResponseDTO(tarefa.getId(),tarefa.getStatus() , tarefa.getCreatedAt(), tarefa.getDescription(), tarefa.getName());

    }

}
