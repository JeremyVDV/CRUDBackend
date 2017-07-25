package org.quintor.crudbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.quintor.crudbackend.dao.PersonDAO;
import org.quintor.crudbackend.rest.dto.PersonDTO;
import org.quintor.crudbackend.model.Person;

public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDAO personDao;

    @Override
    public boolean addPerson(PersonDTO pdto) throws Exception {
        Person person = new Person();
        person.setId(pdto.getId());
        person.setName(pdto.getName());
        person.setTodos(pdto.getTodos());
        return personDao.addPerson(person);
    }

    @Override
    public List<PersonDTO> getPersonList() throws Exception {
        List<Person> list = personDao.getPersonList();
        List<PersonDTO> dtoList = new ArrayList<>();
        for (Person person : list) {
            PersonDTO pdto = new PersonDTO();
            pdto.setId(person.getId());
            pdto.setName(person.getName());
            pdto.setTodos(person.getTodos());
            dtoList.add(pdto);
        }
        return dtoList;
    }

    @Override
    public PersonDTO getPersonById(long id) throws Exception {
        Person person = personDao.getPersonById(id);
        if(person != null) {
            PersonDTO pdto = new PersonDTO();
            pdto.setId(person.getId());
            pdto.setName(person.getName());
            pdto.setTodos(person.getTodos());
            return pdto;
        } else {
            System.out.println("test");
            return null;
        }
    }

    @Override
    public boolean updatePerson(PersonDTO pdto) throws Exception {
        Person person = new Person();
        person.setId(pdto.getId());
        person.setName(pdto.getName());
        person.setTodos(pdto.getTodos());
        return personDao.updatePerson(person);
    }

    @Override
    public boolean deletePerson(long id) throws Exception {
        return personDao.deletePerson(id);
    }
}
