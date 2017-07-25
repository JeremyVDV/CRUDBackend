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
    public boolean addTodo(TodoDTO pdto) throws Exception {
        Todo todo = new Todo();
        todo.setId(pdto.getId());
        todo.setShortdesc(pdto.getShortdesc());
        todo.setLongdesc(pdto.getLongdesc());
        todo.setDate(pdto.getDate());
        todo.setDone(pdto.getDone());
        return todoDao.addTodo(todo);
    }

    @Override
    public TodoDTO getTodoById(long id) throws Exception {
        Todo todo = todoDao.getTodoById(id);
        TodoDTO pdto = new TodoDTO();
        pdto.setId(todo.getId());
        pdto.setShortdesc(todo.getShortdesc());
        pdto.setLongdesc(todo.getLongdesc());
        pdto.setDate(todo.getDate());
        pdto.setDone(todo.getDone());
        return pdto;
    }

    @Override
    public List<TodoDTO> getTodoList() throws Exception {
        List<Todo> list = todoDao.getTodoList();
        List<TodoDTO> dtoList  = new ArrayList<>();
        for(Todo todo : list){
            TodoDTO pdto = new TodoDTO();
            pdto.setId(todo.getId());
            pdto.setShortdesc(todo.getShortdesc());
            pdto.setLongdesc(todo.getLongdesc());
            pdto.setDate(todo.getDate());
            pdto.setDone(todo.getDone());
            dtoList.add(pdto);
        }
        return dtoList;
    }

    @Override
    public boolean deleteTodo(long id) throws Exception {
        return todoDao.deleteTodo(id);
    }
}
