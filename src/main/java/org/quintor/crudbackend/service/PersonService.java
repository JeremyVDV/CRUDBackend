package org.quintor.crudbackend.service;

import java.util.List;

import org.quintor.crudbackend.model.Person;

public interface PersonService {
    //mist nog update
    public boolean addPerson(Person person) throws Exception;
    public List<Person> getPersonList() throws Exception;
    public Person getPersonById(long id) throws Exception;
    public boolean deletePerson(long id) throws Exception;
}

