package org.quintor.crudbackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.quintor.crudbackend.model.Todo;

public class TodoDAOImpl implements TodoDAO {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addTodo(Todo todo) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(todo);
            tx.commit();
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Todo getTodoById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            Todo todo = (Todo) session.load(Todo.class, new Long(id));
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
            return todo;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Todo> getTodoList() throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<Todo> todoList = session.createCriteria(Todo.class).list();
            tx.commit();
            return todoList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean deleteTodo(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Todo.class, id);
            tx = session.getTransaction();
            session.beginTransaction();
            session.delete(o);
            tx.commit();
            return false;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }
}
