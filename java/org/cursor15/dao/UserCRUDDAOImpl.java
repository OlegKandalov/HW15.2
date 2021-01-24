package org.cursor15.dao;

import org.cursor15.models.Book;
import org.cursor15.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCRUDDAOImpl implements LibraryCRUD<User> {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserCRUDDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();
    }

    public User getById(int id) {
        return sessionFactory
                .openSession()
                .get(User.class, id);
    }


    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction tr =  session.beginTransaction();
        session.update(user);
        tr.commit();
        session.close();
    }

    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.delete(user);
        tr.commit();
        session.close();
    }

    public List<User> showAllUsers(User user) {
        List<User> users = (List<User>) sessionFactory.openSession()
                .createQuery("from User").list();
        return users;
    }
}
