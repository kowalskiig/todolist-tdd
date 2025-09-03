package com.todo.list.dto;

public class RequestListaDeTarefa {
    private String name;

    public RequestListaDeTarefa(){}

    public RequestListaDeTarefa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
