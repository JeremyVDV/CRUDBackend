package org.quintor.crudbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.quintor.crudbackend.dao.TodoDAO;
import org.quintor.crudbackend.rest.dto.TodoDTO;
import org.quintor.crudbackend.model.Todo;

public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoDAO todoDao;

    @Override
    public TodoDTO addTodo(TodoDTO tdto) throws Exception {
        Todo todo = new Todo();
        todo.setShortdesc(tdto.getShortdesc());
        todo.setLongdesc(tdto.getLongdesc());
        todo.setDone(tdto.getDone());
        Todo p = todoDao.addTodo(todo);
        tdto.setId(p.getId());
        return tdto;
    }

    @Override
    public List<TodoDTO> getTodoList() throws Exception {
        List<Todo> list = todoDao.getTodoList();
        List<TodoDTO> dtoList = new ArrayList<>();
        for (Todo todo : list) {
            TodoDTO tdto = new TodoDTO();
            tdto.setId(todo.getId());
            tdto.setShortdesc(todo.getShortdesc());
            tdto.setLongdesc(todo.getLongdesc());
            tdto.setDone(todo.getDone());
            dtoList.add(tdto);
        }
        return dtoList;
    }

    @Override
    public TodoDTO getTodoById(long id) throws Exception {
        Todo todo = todoDao.getTodoById(id);
        if(todo != null) {
            TodoDTO tdto = new TodoDTO();
            tdto.setId(todo.getId());
            tdto.setShortdesc(todo.getShortdesc());
            tdto.setLongdesc(todo.getLongdesc());
            tdto.setDone(todo.getDone());
            return tdto;
        } else {
            return null;
        }
    }

    @Override
    public boolean updateTodo(TodoDTO tdto) throws Exception {
        Todo todo = new Todo();
        todo.setId(tdto.getId());
        todo.setShortdesc(tdto.getShortdesc());
        todo.setLongdesc(tdto.getLongdesc());
        todo.setDone(tdto.getDone());
        return todoDao.updateTodo(todo);
    }

    @Override
    public boolean deleteTodo(long id) throws Exception {
        return todoDao.deleteTodo(id);
    }
}
