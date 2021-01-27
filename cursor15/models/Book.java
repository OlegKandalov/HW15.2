package org.cursor15.models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Proxy(lazy = false)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;

    @Column
    private String bookTitle;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    private List<Author> authors;

    @ManyToOne
    @JoinTable(
            name = "book_user",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")}
    )
    private UsersTable user;


    public Book() {}

    public void setBook_id(int id) {
        this.book_id = id;
    }

    public UsersTable getUsers() {
        return user;
    }

    public void setUsers(UsersTable user) {
        this.user = user;
    }

    public int getBook_id() {
        return book_id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + book_id +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
