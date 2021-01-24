package org.cursor15.dao;

import org.cursor15.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCRUDDAOImpl implements LibraryCRUD <Book> {

    private final SessionFactory sessionFactory;

    @Autowired
    public BookCRUDDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.save(book);
        tr.commit();
        session.close();
    }

    @Override
    public Book getById(int id) {
        return sessionFactory.openSession()
                .get(Book.class, id);
    }

    @Override
    public void update(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tr =  session.beginTransaction();
        session.update(book);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Book book) {
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        session.delete(book);
        tr.commit();
        session.close();
    }

    public List<Book> getAllBooks() {
        List<Book> books = (List<Book>) sessionFactory.openSession()
                .createQuery("from Book").list();
        return books;
    }
}
