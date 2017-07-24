package org.quintor.crudbackend.dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.quintor.crudbackend.model.Person;

public class PersonDAOImpl implements PersonDAO {
    @Autowired
    SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Override
    public boolean addPerson(Person person) throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(person);
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
    public Person getPersonById(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            Person person = (Person) session.load(Person.class, new Long(id));
            Hibernate.initialize(person.getTodos());
            tx = session.getTransaction();
            session.beginTransaction();
            tx.commit();
            return person;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getPersonList() throws Exception {
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            List<Person> personList = session.createCriteria(Person.class).list();
            tx.commit();
            return personList;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updatePerson(long id) throws Exception {
        return false;
    }

    @Override
    public boolean deletePerson(long id) throws Exception {
        try {
            session = sessionFactory.openSession();
            Object o = session.load(Person.class, id);
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
