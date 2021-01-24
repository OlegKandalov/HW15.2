package org.cursor15.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Book> books;

    public User() {}

    public User(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        book.setUser(this);
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return new User();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
