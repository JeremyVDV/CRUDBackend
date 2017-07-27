package org.quintor.crudbackend.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.quintor.crudbackend.rest.dto.TodoDTO;
import org.quintor.crudbackend.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    static final Logger logger = Logger.getLogger(TodoController.class);

    /*--------------- CREATE TODO ------------------------------------------------------------------------*/
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addTodo(@RequestBody TodoDTO todo) throws Exception {
        todoService.addTodo(todo);
        logger.info("Todo created with short description: " + todo.getShortdesc());
        return new ResponseEntity(todo, HttpStatus.CREATED);
    }


    /*--------------- RETRIEVE SINGLE TODO BY ID ---------------------------------------------------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getTodo(@PathVariable("id") long id) throws Exception {
        TodoDTO todo = todoService.getTodoById(id);
        if(todo == null) {
            logger.error("Todo with id -" + id + "- not found");
            return new ResponseEntity("Not able retrieve todo. Todo with id "+ id +" not found", HttpStatus.NOT_FOUND);
        }
        logger.info("Todo with id -" + id + "- retrieved");
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    /*--------------- UPDATE TODO -------------------------------------------------------------------------*/
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateTodo(@PathVariable("id") long id, @RequestBody TodoDTO todo) throws Exception {
        TodoDTO currentTodo = todoService.getTodoById(id);
        if(currentTodo == null) {
            logger.error("Todo with id -" + id + "- not found");
            return new ResponseEntity("Not able retrieve todo. Todo with id "+ id +" not found", HttpStatus.NOT_FOUND);
        }
        currentTodo.setShortdesc(todo.getShortdesc());
        currentTodo.setLongdesc(todo.getLongdesc());
        currentTodo.setDone(todo.getDone());
        todoService.updateTodo(currentTodo);
        logger.info("Todo with id -" + id + "- updated");
        return new ResponseEntity(currentTodo, HttpStatus.OK);
    }

    /*--------------- RETRIEVE ALL TODOS ------------------------------------------------------------------*/
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity getTodo() throws Exception{
        List<TodoDTO> todoList = todoService.getTodoList();
        if(todoList.isEmpty()) {
            logger.error("Todo list could not be retrieved");
            return new ResponseEntity("Todo list could not be retrieved", HttpStatus.NOT_FOUND);
        }
        logger.info("Todo list has been retrieved");
        return new ResponseEntity(todoList, HttpStatus.OK);
    }

    /*--------------- DELETE TODO ------------------------------------------------------------------------*/
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteTodo(@PathVariable("id") long id) throws Exception{
        TodoDTO todo = todoService.getTodoById(id);
        if(todo == null) {
            logger.error("Todo with id -" + id + "- not found");
            return new ResponseEntity("Not able to delete. Todo with id "+ id +" not found", HttpStatus.NOT_FOUND);
        }
        todoService.deleteTodo(id);
        logger.info("Todo with id -" + id + "- deleted");
        return new ResponseEntity(HttpStatus.OK);
    }
}
