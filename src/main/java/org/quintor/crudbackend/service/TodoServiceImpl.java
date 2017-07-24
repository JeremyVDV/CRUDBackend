package org.quintor.crudbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.quintor.crudbackend.dao.TodoDAO;
import org.quintor.crudbackend.model.Todo;

public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDAO todoDao;

    @Override
    public boolean addTodo(Todo todo) throws Exception {
        return todoDao.addTodo(todo);
    }

    @Override
    public Todo getTodoById(long id) throws Exception {
        return todoDao.getTodoById(id);
    }

    @Override
    public List<Todo> getTodoList() throws Exception {
        return todoDao.getTodoList();
    }

    @Override
    public boolean deleteTodo(long id) throws Exception {
        return todoDao.deleteTodo(id);
    }
}
