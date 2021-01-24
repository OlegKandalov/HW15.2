package org.cursor15;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan ("org.cursor15")
public class SpringConfig {
    @Bean
    SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = null;
        try {
            org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("This is bad " + e);
        }
        return sessionFactory;
    }
}
