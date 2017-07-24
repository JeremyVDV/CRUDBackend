package org.quintor.crudbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.quintor.crudbackend.dao.PersonDAO;
import org.quintor.crudbackend.model.Person;

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDao;

    @Override
    public boolean addPerson(Person person) throws Exception {
        return personDao.addPerson(person);
    }

    @Override
    public Person getPersonById(long id) throws Exception {
        return null;
    }

    @Override
    public List<Person> getPersonList() throws Exception {
        return personDao.getPersonList();
    }

    @Override
    public boolean deletePerson(long id) throws Exception {
        return personDao.deletePerson(id);
    }
}
