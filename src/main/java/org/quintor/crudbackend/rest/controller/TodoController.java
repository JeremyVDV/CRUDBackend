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

import org.quintor.crudbackend.model.Todo;
import org.quintor.crudbackend.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoService todoService;

    static final Logger logger = Logger.getLogger(TodoController.class);

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addTodo(@RequestBody Todo todo) {
        try {
            todoService.addTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getTodo(@PathVariable("id") long id) {
        Todo todo = null;
        try {
            todo = todoService.getTodoById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(todo, HttpStatus.OK);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public  ResponseEntity getTodo() {
        List<Todo> todoList = null;
        try {
            todoList = todoService.getTodoList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(todoList, HttpStatus.OK);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteTodo(@PathVariable("id") long id) {
        try {
            todoService.deleteTodo(id);
            return new ResponseEntity(null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
