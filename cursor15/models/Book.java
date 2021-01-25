package org.cursor15.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String bookTitle;

    @ManyToOne
    @JoinColumn
    private UsersTable user;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Author> authors;

    public Book() {}

    public void setId(int id) {
        this.id = id;
    }

    public UsersTable getUsers() {
        return user;
    }

    public void setUsers(UsersTable user) {
        this.user = user;
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
