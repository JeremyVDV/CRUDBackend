package org.quintor.crudbackend.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.quintor.crudbackend.model.Person;
import org.quintor.crudbackend.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    static final Logger logger = Logger.getLogger(PersonController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPerson(@RequestBody Person person) {
        try {
            personService.addPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPerson(@PathVariable("id") long id) {
        Person person = null;
        try {
            person = personService.getPersonById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getPerson() {
        List<Person> personList = null;
        try {
            personList = personService.getPersonList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(personList, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deletePerson(@PathVariable("id") long id) {
        try {
            personService.deletePerson(id);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }

    }
}
