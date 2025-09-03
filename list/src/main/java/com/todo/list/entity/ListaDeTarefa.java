package com.todo.list.entity;



import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_lista_tarefas")
public class ListaDeTarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Tarefa> tarefas = new ArrayList<>();

    public ListaDeTarefa(){}


    public ListaDeTarefa(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public String getName() {
        return name;
    }
}
