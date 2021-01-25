package org.cursor15;

import org.cursor15.dao.AuthorCRUDDAOImpl;
import org.cursor15.dao.BookCRUDDAOImpl;
import org.cursor15.dao.UserCRUDDAOImpl;
import org.cursor15.models.Author;
import org.cursor15.models.Book;
import org.cursor15.models.UsersTable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserCRUDDAOImpl userCRUDDAO = context.getBean(UserCRUDDAOImpl.class);
        BookCRUDDAOImpl bookCRUDDAO = context.getBean(BookCRUDDAOImpl.class);
        AuthorCRUDDAOImpl authorCRUDDAO = context.getBean(AuthorCRUDDAOImpl.class);

        Author joanneRowling = new Author();
        joanneRowling.setAuthorName("Joanne Rowling");
        Author michaelJeffreyJordan = new Author();
        michaelJeffreyJordan.setAuthorName("Michael Jeffrey Jordan");
        Author cliveStaplesLewis = new Author();
        cliveStaplesLewis.setAuthorName("Clive Lewis");

        Book harryPotter1 = new Book();
        harryPotter1.setBookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter2 = new Book();
        harryPotter2.setBookTitle("Harry Potter and the Chamber of Secrets");
        Book theLionTheWitchAndTheWardrobe = new Book();
        theLionTheWitchAndTheWardrobe.setBookTitle("The Lion, the Witch and the Wardrobe");

        UsersTable martin = new UsersTable();
        martin.setName("Martin");

        UsersTable tim = new UsersTable();
        tim.setName("Tim");


        userCRUDDAO.create(martin);
        userCRUDDAO.create(tim);
        authorCRUDDAO.create(joanneRowling);
        authorCRUDDAO.create(michaelJeffreyJordan);
        bookCRUDDAO.create(harryPotter1);
        bookCRUDDAO.create(harryPotter2);

        List<Author> jAndM = new ArrayList<>();
        jAndM.add(joanneRowling);
        jAndM.add(michaelJeffreyJordan);
        harryPotter1.setUsers(martin);
        harryPotter2.setUsers(tim);
        joanneRowling.setBook(harryPotter1);
        michaelJeffreyJordan.setBook(harryPotter2);

        bookCRUDDAO.update(harryPotter1);
        bookCRUDDAO.update(harryPotter2);

        authorCRUDDAO.update(michaelJeffreyJordan);
        authorCRUDDAO.update(joanneRowling);

    }
}
