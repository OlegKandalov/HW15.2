package org.cursor15;

import org.cursor15.dao.AuthorCRUDDAOImpl;
import org.cursor15.dao.BookCRUDDAOImpl;
import org.cursor15.dao.UserCRUDDAOImpl;
import org.cursor15.models.Author;
import org.cursor15.models.Book;
import org.cursor15.models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserCRUDDAOImpl userCRUDDAO = context.getBean(UserCRUDDAOImpl.class);
        BookCRUDDAOImpl bookCRUDDAO = context.getBean(BookCRUDDAOImpl.class);
        AuthorCRUDDAOImpl authorCRUDDAO = context.getBean(AuthorCRUDDAOImpl.class);

        Author joanneRowling = new Author();
        joanneRowling.setAuthorName("Joanne Rowling");
        joanneRowling.setId(1);
        Author michaelJeffreyJordan = new Author();
        michaelJeffreyJordan.setAuthorName("Michael Jeffrey Jordan");
        michaelJeffreyJordan.setId(2);
        Author cliveStaplesLewis = new Author();
        cliveStaplesLewis.setAuthorName("Clive Lewis");
        cliveStaplesLewis.setId(3);

        Book harryPotter1 = new Book();
        harryPotter1.setBookTitle("Harry Potter and the Philosopher's Stone");
        harryPotter1.setId(55);
        Book harryPotter2 = new Book();
        harryPotter2.setBookTitle("Harry Potter and the Chamber of Secrets");
        harryPotter2.setId(56);
        Book theLionTheWitchAndTheWardrobe = new Book();
        theLionTheWitchAndTheWardrobe.setBookTitle("The Lion, the Witch and the Wardrobe");
        theLionTheWitchAndTheWardrobe.setId(356);

        User martin = new User();
        martin.setName("Martin");
        martin.setId(3);

//        userCRUDDAO.create(martin);
//        authorCRUDDAO.create(joanneRowling);
//        authorCRUDDAO.create(michaelJeffreyJordan);
//        bookCRUDDAO.create(harryPotter1);
//        bookCRUDDAO.create(harryPotter2);
//
//        User user1 = userCRUDDAO.getById(1);
//
        List<Author> jAndM = new ArrayList<>();
        Author author1 = authorCRUDDAO.getById(1);
        Author author2 = authorCRUDDAO.getById(2);
        jAndM.add(author1);
        Book book = bookCRUDDAO.getById(55);
        book.setAuthors(jAndM);
        bookCRUDDAO.update(book);

    }
}
