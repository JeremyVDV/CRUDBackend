package org.quintor.crudbackend.rest.dto;

import org.quintor.crudbackend.model.Todo;

import java.io.Serializable;
import java.util.Set;

public class PersonDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private Set<Todo> todos;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        this.name = name;
    }

    public Set<Todo> getTodos() { return todos; }
    public void setTodos(Set<Todo> todos) { this.todos = todos; }
}
