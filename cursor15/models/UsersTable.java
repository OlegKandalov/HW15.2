package org.cursor15.models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Proxy(lazy = false)
public class UsersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int user_id;

    @Column
    private String name;

    @OneToMany
    @JoinTable(
            name = "book_user",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> books;

    public UsersTable() {
    }

    public void addBook(Book book){
        //book.setUser(this);
        books.add(book);
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "id=" + user_id +
                ", name='" + name + '\'' +
                '}';
    }
}
