package org.cursor15.dao;

import org.cursor15.utils.HibernateSessionFactoryUtil;
import org.cursor15.models.UsersTable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCRUDDAOImpl implements LibraryCRUD<UsersTable> {

    public void create(UsersTable user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(user);
        tr.commit();
        session.close();
    }

    public UsersTable getById(int id) {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .get(UsersTable.class, id);
    }


    public void update(UsersTable user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr =  session.beginTransaction();
        session.update(user);
        tr.commit();
        session.close();
    }

    public void delete(UsersTable user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(user);
        tr.commit();
        session.close();
    }

    public List<UsersTable> showAllUsers(UsersTable user) {
        List<UsersTable> users = (List<UsersTable>) HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("from UsersTable").list();
        return users;
    }
}
