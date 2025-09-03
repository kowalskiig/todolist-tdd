package com.todo.list.dto;

import java.util.ArrayList;
import java.util.List;

public class RespondeListaDeTarefa {

    private Long id;

    private String name;

    private List<TarefaResponseDTO> tarefas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<TarefaResponseDTO> getTarefas() {
        return tarefa;
    }
}
