package com.todo.list.dto;

public class TarefaRequestDTO {
    private String name;
    private  String description;

    public TarefaRequestDTO(){}

    public TarefaRequestDTO(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
