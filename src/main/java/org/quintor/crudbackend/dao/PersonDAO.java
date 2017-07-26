package org.quintor.crudbackend.dao;

import java.util.List;
import org.quintor.crudbackend.model.Person;

public interface PersonDAO {
    //mist nog update
    Person addPerson(Person person) throws Exception;
    List<Person> getPersonList() throws Exception;
    Person getPersonById(long id) throws Exception;
    boolean updatePerson(Person person) throws Exception;
    boolean deletePerson(long id) throws Exception;
}
