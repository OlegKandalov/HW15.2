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
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserCRUDDAOImpl userCRUDDAO = context.getBean(UserCRUDDAOImpl.class);
        BookCRUDDAOImpl bookCRUDDAO = context.getBean(BookCRUDDAOImpl.class);
        AuthorCRUDDAOImpl authorCRUDDAO = context.getBean(AuthorCRUDDAOImpl.class);

        Author joanneRowling = context.getBean(Author.class);
        joanneRowling.setAuthorName("Joanne Rowling");
        Author michaelJeffreyJordan = context.getBean(Author.class);
        michaelJeffreyJordan.setAuthorName("Michael Jeffrey Jordan");
        Author cliveStaplesLewis = context.getBean(Author.class);
        cliveStaplesLewis.setAuthorName("Clive Lewis");

        List<Author> jAndM = new ArrayList<>();
        jAndM.add(joanneRowling);
        jAndM.add(michaelJeffreyJordan);

        Book harryPotter1 = context.getBean(Book.class);
        harryPotter1.setBookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter2 = context.getBean(Book.class);
        harryPotter2.setBookTitle("Harry Potter and the Chamber of Secrets");
        Book theLionTheWitchAndTheWardrobe = context.getBean(Book.class);
        theLionTheWitchAndTheWardrobe.setBookTitle("The Lion, the Witch and the Wardrobe");

        User martin = context.getBean(User.class);
        martin.setName("Martin");

        userCRUDDAO.create(martin);
        bookCRUDDAO.create(harryPotter1);
        authorCRUDDAO.create(michaelJeffreyJordan);

    }
}
