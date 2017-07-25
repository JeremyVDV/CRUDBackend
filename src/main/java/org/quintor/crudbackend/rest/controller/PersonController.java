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

import org.quintor.crudbackend.rest.dto.PersonDTO;
import org.quintor.crudbackend.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    static final Logger logger = Logger.getLogger(PersonController.class);

    /*--------------- CREATE PERSON ------------------------------------------------------------------------*/
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPerson(@RequestBody PersonDTO person) throws Exception {
        personService.addPerson(person);
        return new ResponseEntity("Person succesfully created", HttpStatus.CREATED);
    }


    /*--------------- RETRIEVE SINGLE PERSON BY ID ---------------------------------------------------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getPerson(@PathVariable("id") long id) throws Exception {
        PersonDTO person = personService.getPersonById(id);
        if(person == null) {
            logger.error("Person with id -" + id + "- not found");
            return new ResponseEntity("Not able retrieve person. Person with the id of "+ id +" not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(person, HttpStatus.OK);
    }

    /*--------------- UPDATE PERSON -------------------------------------------------------------------------*/
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updatePerson(@PathVariable("id") long id, @RequestBody PersonDTO person) throws Exception {
        PersonDTO currentPerson = personService.getPersonById(id);
        if(currentPerson == null) {
            logger.error("Person with id -" + id + "- not found");
            return new ResponseEntity("Not able retrieve person. Person with the id of "+ id +" not found", HttpStatus.NOT_FOUND);
        }

        currentPerson.setName(person.getName());
        currentPerson.setTodos(person.getTodos());

        personService.updatePerson(currentPerson);
        return new ResponseEntity(currentPerson, HttpStatus.OK);
    }

    /*--------------- RETRIEVE ALL PERSONS ------------------------------------------------------------------*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getPerson() throws Exception{
        List<PersonDTO> personList = personService.getPersonList();
        if(personList.isEmpty()) {
            logger.error("No persons could be retrieved");
            return new ResponseEntity("No persons could be retrieved", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(personList, HttpStatus.OK);
    }

    /*--------------- DELETE PERSON ------------------------------------------------------------------------*/
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deletePerson(@PathVariable("id") long id) throws Exception{
        PersonDTO person = personService.getPersonById(id);
        if(person == null) {
            logger.error("Person with id -" + id + "- not found");
            return new ResponseEntity("Not able to delete. Person with the id of "+ id +" not found", HttpStatus.NOT_FOUND);
        }
        personService.deletePerson(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
