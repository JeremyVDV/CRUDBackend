package org.quintor.crudbackend.service;

import java.util.List;

import org.quintor.crudbackend.rest.dto.PersonDTO;

public interface PersonService {
    PersonDTO addPerson(PersonDTO person) throws Exception;
    List<PersonDTO> getPersonList() throws Exception;
    PersonDTO getPersonById(long id) throws Exception;
    boolean updatePerson(PersonDTO person) throws Exception;
    boolean deletePerson(long id) throws Exception;
}

