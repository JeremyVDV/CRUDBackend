package org.quintor.crudbackend.model;


import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Proxy(lazy = false)
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Todo> todos;

    public Set<Todo> getTodos() { return todos; }
    public void setTodos(Set<Todo> todos) { this.todos = todos; }
}
