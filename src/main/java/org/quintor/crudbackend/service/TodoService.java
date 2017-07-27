package org.quintor.crudbackend.service;

import java.util.List;

import org.quintor.crudbackend.rest.dto.TodoDTO;

public interface TodoService {
    TodoDTO addTodo(TodoDTO todo) throws Exception;
    List<TodoDTO> getTodoList() throws Exception;
    TodoDTO getTodoById(long id) throws Exception;
    boolean updateTodo(TodoDTO todo) throws Exception;
    boolean deleteTodo(long id) throws Exception;
}

