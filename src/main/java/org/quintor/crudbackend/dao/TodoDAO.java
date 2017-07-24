package org.quintor.crudbackend.dao;

import java.util.List;
import org.quintor.crudbackend.model.Todo;

public interface TodoDAO {
    //mist nog update
    public boolean addTodo(Todo todo) throws Exception;
    public List<Todo> getTodoList() throws Exception;
    public Todo getTodoById(long id) throws Exception;
    public boolean deleteTodo(long id) throws Exception;
}
