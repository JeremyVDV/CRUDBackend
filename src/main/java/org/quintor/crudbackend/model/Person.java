package org.quintor.crudbackend.model;

import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "personid")
    private long id;

    public long getId() { return id; }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "person_has_todo", joinColumns = {
            @JoinColumn(name = "personid", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "todoid",
                    nullable = false, updatable = false) })
    private Set<Todo> todos;

    public Set<Todo> getTodos() { return todos; }
    public void setTodos(Set<Todo> todos) { this.todos = todos; }
}
