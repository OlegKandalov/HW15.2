package org.cursor15.dao;

import org.cursor15.utils.HibernateSessionFactoryUtil;
import org.cursor15.models.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorCRUDDAOImpl implements LibraryCRUD<Author> {

    @Override
    public void create(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(author);
        tr.commit();
        session.close();
    }

    @Override
    public Author getById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Author.class, id);
    }

    @Override
    public void update(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr =  session.beginTransaction();
        session.update(author);
        tr.commit();
        session.close();
    }

    public void deleteById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        Author author = HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(Author.class, id);
        session.delete(author);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Author author) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(author);
        tr.commit();
        session.close();
    }

    public List<Author> getAllAuthors() {
        List<Author> authors = (List<Author>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from Author").list();
        return authors;
    }
}
