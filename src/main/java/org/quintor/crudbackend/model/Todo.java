package org.quintor.crudbackend.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    @Column(name = "short_description")
    private String shortdesc;

    public String getShortdesc() { return shortdesc; }
    public void setShortdesc(String shortdesc) { this.shortdesc = shortdesc; }

    @Column(name = "long_description")
    private String longdesc;

    public String getLongdesc() { return longdesc; }
    public void setLongdesc(String longdesc) { this.longdesc = longdesc; }

    @Column(name = "date")
    private String date;

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    @Column(name = "done")
    private int done;

    public int getDone() { return done; }
    public void setDone(int done) { this.done = done; }

    @ManyToOne
    @JoinColumn(name = "personid")
    private Person person;

    public Person getPerson() {return person;}
    public void setPerson(Person person) {this.person = person;}
}
