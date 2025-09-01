package com.todo.list.exceptions;

public class UnprocessableEntity extends RuntimeException {
    public UnprocessableEntity(String message) {
        super(message);
    }
}
