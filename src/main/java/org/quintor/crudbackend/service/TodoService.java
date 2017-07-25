package org.quintor.crudbackend.service;

import java.util.List;

import org.quintor.crudbackend.rest.dto.TodoDTO;

public interface TodoService {
    //mist nog update
    public boolean addTodo(TodoDTO todo) throws Exception;
    public List<TodoDTO> getTodoList() throws Exception;
    public TodoDTO getTodoById(long id) throws Exception;
    public boolean deleteTodo(long id) throws Exception;
}

