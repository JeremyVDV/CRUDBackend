package org.quintor.crudbackend.model;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private Set<Todo> todos;

    public Set<Todo> getTodos() { return todos; }
    public void setTodos(Set<Todo> todos) { this.todos = todos; }
}
