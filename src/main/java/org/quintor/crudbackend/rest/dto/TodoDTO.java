package org.quintor.crudbackend.rest.dto;

import java.io.Serializable;

public class TodoDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    private long id;
    private String shortdesc;
    private String longdesc;
    private String date;
    private int done;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getShortdesc() { return shortdesc; }
    public void setShortdesc(String shortdesc) { this.shortdesc = shortdesc; }

    public String getLongdesc() { return longdesc; }
    public void setLongdesc(String longdesc) { this.longdesc = longdesc; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public int getDone() { return done; }
    public void setDone(int done) { this.done = done; }
}
