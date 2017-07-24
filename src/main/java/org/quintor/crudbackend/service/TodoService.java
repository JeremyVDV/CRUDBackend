package org.quintor.crudbackend.service;

import java.util.List;

import org.quintor.crudbackend.model.Todo;

public interface TodoService {
    //mist nog update
    public boolean addTodo(Todo todo) throws Exception;
    public List<Todo> getTodoList() throws Exception;
    public Todo getTodoById(long id) throws Exception;
    public boolean deleteTodo(long id) throws Exception;
}

