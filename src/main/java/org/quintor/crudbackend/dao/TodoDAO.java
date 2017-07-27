package org.quintor.crudbackend.dao;

import java.util.List;
import org.quintor.crudbackend.model.Todo;

public interface TodoDAO {
    Todo addTodo(Todo todo) throws Exception;
    List<Todo> getTodoList() throws Exception;
    Todo getTodoById(long id) throws Exception;
    boolean updateTodo(Todo todo) throws Exception;
    boolean deleteTodo(long id) throws Exception;
}
