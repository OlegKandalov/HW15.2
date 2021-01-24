package org.cursor15.service;

import org.cursor15.dao.UserCRUDDAOImpl;
import org.cursor15.models.Book;
import org.cursor15.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserCRUDService {

    UserCRUDDAOImpl userDAO;

    public void createUser(User user) {
        userDAO.create(user);
    }

    public void readUserById(int id) {
        System.out.println(userDAO.getById(id));
    }

    public void updateUser(User user) {
        userDAO.update(user);
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }

}
