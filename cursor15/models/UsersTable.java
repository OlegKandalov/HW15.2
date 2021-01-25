package org.cursor15.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class UsersTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Book> books;

    public UsersTable() {
        //books = new ArrayList<>();
    }

    public void addBook(Book book){
        //book.setUser(this);
        books.add(book);
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
