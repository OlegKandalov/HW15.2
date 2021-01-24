//package org.cursor15.utils;
//
//import org.cursor15.models.Author;
//import org.cursor15.models.Book;
//import org.cursor15.models.User;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class HibernateSessionFactoryUtil {
//    private static SessionFactory sessionFactory;
//
//    @Autowired
//    private HibernateSessionFactoryUtil() {}
//
//    public static SessionFactory getSessionFactory() {
//        if (sessionFactory == null) {
//            try {
//                Configuration configuration = new Configuration().configure();
//                configuration.addAnnotatedClass(User.class);
//                configuration.addAnnotatedClass(Book.class);
//                configuration.addAnnotatedClass(Author.class);
//                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//                        .applySettings(configuration.getProperties());
//                sessionFactory = configuration.buildSessionFactory(builder.build());
//            } catch (Exception e) {
//                System.out.println("This is bad");
//            }
//        }
//        return sessionFactory;
//    }
//}