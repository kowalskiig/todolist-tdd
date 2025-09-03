package com.todo.list.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseListaDeTarefa {

    private Long id;

    private String name;

    private List<TarefaResponseDTO> tarefas = new ArrayList<>();

    public ResponseListaDeTarefa(){

    }

    public ResponseListaDeTarefa(Long id, List<TarefaResponseDTO> tarefas, String name) {
        this.id = id;
        this.tarefas = tarefas;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TarefaResponseDTO> getTarefas() {
        return tarefas;
    }
}
