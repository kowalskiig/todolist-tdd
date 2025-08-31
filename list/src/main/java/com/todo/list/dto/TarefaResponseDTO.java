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

    public TarefaResponseDTO(Long id, TarefaStatus tarefaStatus, Instant createdAt, String description, String title) {
        this.id = id;
        this.tarefaStatus = tarefaStatus;
        this.createdAt = createdAt;
        this.description = description;
        this.title = title;
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
