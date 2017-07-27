package org.quintor.crudbackend.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "todo")
public class Todo implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "todoid")
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

    @Column(name = "done")
    private int done;

    public int getDone() { return done; }
    public void setDone(int done) { this.done = done; }
}
