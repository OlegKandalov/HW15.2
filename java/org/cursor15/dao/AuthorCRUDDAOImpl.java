package org.cursor15.dao;

import org.cursor15.models.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorCRUDDAOImpl implements LibraryCRUD<Author> {

    private SessionFactory sessionFactory;

    @Autowired
    public AuthorCRUDDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(author);
        tr.commit();
        session.close();
    }

    @Override
    public Author getById(int id) {
        return sessionFactory.openSession()
                .get(Author.class, id);
    }

    @Override
    public void update(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tr =  session.beginTransaction();
        session.update(author);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.delete(author);
        tr.commit();
        session.close();
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = (List<Author>) sessionFactory.openSession()
                .createQuery("from Author").list();
        return authors;
    }
}
