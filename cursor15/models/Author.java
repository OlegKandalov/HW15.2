package org.cursor15.models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Proxy(lazy = false)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;

    @Column
    private String authorName;

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "author_id")},
            inverseJoinColumns = {@JoinColumn(name = "book_id")}
    )
    private List<Book> book;

    public Author() {}

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public void setAuthor_id(int id) {
        this.author_id = id;
    }

    public int getAuthor_id() {
        return author_id;
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
