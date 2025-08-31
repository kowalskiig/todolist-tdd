package com.todo.list.entity;

import com.todo.list.enums.TarefaStatus;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "tb_tarefas")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Instant createdAt;
    @Enumerated(EnumType.STRING)
    private TarefaStatus status;

    public Tarefa(){

    }

    public Tarefa(String name, String description, Instant instant) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.status = TarefaStatus.CRIADA;
    }

    public Long getId() {
        return id;
    }

    public TarefaStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
