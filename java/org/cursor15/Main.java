package org.cursor15;

import org.cursor15.models.Author;
import org.cursor15.models.Book;
import org.cursor15.service.AuthorCRUDService;
import org.cursor15.service.BookCRUDService;
import org.cursor15.service.UserCRUDService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserCRUDService userService = context.getBean(UserCRUDService.class);
        BookCRUDService bookService = context.getBean(BookCRUDService.class);
        AuthorCRUDService authorService = context.getBean(AuthorCRUDService.class);

        Author joanneRowling = context.getBean(Author.class);
        joanneRowling.setAuthorName("Joanne Rowling");
        Author michaelJeffreyJordan = context.getBean(Author.class);
        michaelJeffreyJordan.setAuthorName("Michael Jeffrey Jordan");
        Book harryPotter1 = context.getBean(Book.class);
        harryPotter1.setBookTitle("Harry Potter and the Philosopher's Stone");
        Book harryPotter2 = context.getBean(Book.class);
        harryPotter2.setBookTitle("Harry Potter and the Chamber of Secrets");
        harryPotter1.setAuthors(joanneRowling);
        harryPotter1.setAuthors(michaelJeffreyJordan);
        harryPotter2.setAuthors(joanneRowling);

        Author cliveStaplesLewis = context.getBean(Author.class);
        cliveStaplesLewis.setAuthorName("Clive Lewis");
        Book theLionTheWitchAndTheWardrobe = context.getBean(Book.class);
        theLionTheWitchAndTheWardrobe.setBookTitle("The Lion, the Witch and the Wardrobe");
        theLionTheWitchAndTheWardrobe.setAuthors(cliveStaplesLewis);

    }
}
