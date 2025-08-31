package com.todo.list.dto;

import com.todo.list.entity.Tarefa;
import com.todo.list.enums.TarefaStatus;

import java.time.Instant;

public class TarefaResponseDTO {

    private Long id;
    private String title;
    private String description;
    private Instant createdAt;
    private TarefaStatus tarefaStatus;

    public TarefaResponseDTO(){

    }

    public TarefaResponseDTO(Tarefa tarefa){
        id = tarefa.getId();
        title = tarefa.getName();
        description = tarefa.getDescription();
        createdAt = tarefa.getCreatedAt();
        tarefaStatus = tarefa.getStatus();
    }

    public Long getId() {
        return id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public TarefaStatus getTarefaStatus() {
        return tarefaStatus;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
