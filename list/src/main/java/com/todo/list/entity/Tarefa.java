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

    @ManyToOne
    @JoinColumn(name = "listatarefa_id")
    private ListaDeTarefa listaDeTarefa;

    public Tarefa(){

    }

    public Tarefa(Long id, TarefaStatus status, String description, Instant createdAt, String name) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.createdAt = createdAt;
        this.name = name;
    }

    public Tarefa(String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = Instant.now();
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

    public void setStatus(TarefaStatus status) {
        this.status = status;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
