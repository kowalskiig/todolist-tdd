package com.todo.list.dto;

import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;

import java.time.Instant;

public class TarefaResponseDTO {

    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    private TarefaStatus status;

    public TarefaResponseDTO(){

    }

    public TarefaResponseDTO(Tarefa tarefa){
        id = tarefa.getId();
        name = tarefa.getName();
        description = tarefa.getDescription();
        createdAt = tarefa.getCreatedAt();
        status = tarefa.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
