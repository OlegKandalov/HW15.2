package org.cursor15.service;

import org.cursor15.dao.AuthorCRUDDAOImpl;
import org.cursor15.models.Author;
import org.cursor15.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorCRUDService {

    AuthorCRUDDAOImpl authorCRUDDAO;

    public void createAuthor(Author author) {
        authorCRUDDAO.create(author);
    }

    public void readAuthorById(int id) {
        System.out.println(authorCRUDDAO.getById(id));
    }

    public void updateAuthor(Author author) {
        authorCRUDDAO.update(author);
    }

    public void deleteAuthor(Author author) {
        authorCRUDDAO.delete(author);
    }

    public List<Author> getAllBook() {
        return authorCRUDDAO.getAllAuthors();
    }
}
