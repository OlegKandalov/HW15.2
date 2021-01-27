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

        List<Author> authorsJAndM = new ArrayList<>();
        authorsJAndM.add(joanneRowling);
        authorsJAndM.add(michaelJeffreyJordan);
        List<Author> authorsLewis = new ArrayList<>();
        authorsLewis.add(cliveStaplesLewis);

        Book harryPotter1 = new Book();
        harryPotter1.setBookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter2 = new Book();
        harryPotter2.setBookTitle("Harry Potter and the Chamber of Secrets");
        Book theLionTheWitchAndTheWardrobe = new Book();
        theLionTheWitchAndTheWardrobe.setBookTitle("The Lion, the Witch and the Wardrobe");

        List<Book> booksForAuthorJAndM = new ArrayList<>();
        booksForAuthorJAndM.add(harryPotter1);
        booksForAuthorJAndM.add(harryPotter2);
        List<Book> booksForAuthorClive = new ArrayList<>();
        booksForAuthorClive.add(theLionTheWitchAndTheWardrobe);

        List<Book> booksForUserMartin = new ArrayList<>();
        booksForUserMartin.add(harryPotter1);
        List<Book> booksForUserTim = new ArrayList<>();
        booksForUserTim.add(harryPotter2);
        List<Book> booksForUserLena = new ArrayList<>();
        booksForUserLena.add(theLionTheWitchAndTheWardrobe);

        UsersTable martin = new UsersTable();
        martin.setName("Martin");
        UsersTable tim = new UsersTable();
        tim.setName("Tim");
        UsersTable lena = new UsersTable();
        lena.setName("Lena");

        userCRUDDAO.create(martin);
        userCRUDDAO.create(tim);
        userCRUDDAO.create(lena);
        authorCRUDDAO.create(joanneRowling);
        authorCRUDDAO.create(michaelJeffreyJordan);
        authorCRUDDAO.create(cliveStaplesLewis);
        bookCRUDDAO.create(harryPotter1);
        bookCRUDDAO.create(harryPotter2);
        bookCRUDDAO.create(theLionTheWitchAndTheWardrobe);



        harryPotter1.setUsers(martin);
        martin.setBooks(booksForUserMartin);
        harryPotter2.setUsers(tim);
        tim.setBooks(booksForUserTim);
        theLionTheWitchAndTheWardrobe.setUsers(lena);
        lena.setBooks(booksForUserLena);
        joanneRowling.setBook(booksForAuthorJAndM);
        michaelJeffreyJordan.setBook(booksForAuthorJAndM);
        harryPotter1.setAuthors(authorsJAndM);
        harryPotter2.setAuthors(authorsJAndM);
        cliveStaplesLewis.setBook(booksForAuthorClive);
        theLionTheWitchAndTheWardrobe.setAuthors(authorsLewis);


        userCRUDDAO.update(martin);
        userCRUDDAO.update(tim);
        userCRUDDAO.update(lena);
        bookCRUDDAO.update(harryPotter1);
        bookCRUDDAO.update(harryPotter2);
        bookCRUDDAO.update(theLionTheWitchAndTheWardrobe);
        authorCRUDDAO.update(michaelJeffreyJordan);
        authorCRUDDAO.update(joanneRowling);
        authorCRUDDAO.update(cliveStaplesLewis);

    }
}
