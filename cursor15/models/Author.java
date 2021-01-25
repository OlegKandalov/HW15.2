package org.cursor15.models;

import javax.persistence.*;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String authorName;

    @ManyToOne
    @JoinColumn
    private Book book;

    public Author() {}

    public void setBook(Book book) {
        this.book = book;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorName='" + authorName + '\'' +
                '}';
    }
}
