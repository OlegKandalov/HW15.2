package org.cursor15.service;

import org.cursor15.dao.BookCRUDDAOImpl;
import org.cursor15.dao.UserCRUDDAOImpl;
import org.cursor15.models.Book;
import org.cursor15.models.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCRUDService {

    BookCRUDDAOImpl bookCRUDDAO;

    public void createBook(Book book) {
        bookCRUDDAO.create(book);
    }

    public void readBookById(int id) {
        System.out.println(bookCRUDDAO.getById(id));
    }

    public void updateBook(Book book) {
        bookCRUDDAO.update(book);
    }

    public void deleteBook(Book book) {
        bookCRUDDAO.delete(book);
    }

    public List<Book> getAllBook() {
        return bookCRUDDAO.getAllBooks();
    }
}
