CREATE DATABASE library;

CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL
);

CREATE TABLE books
(
    id SERIAL PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    user_id INT,
    CONSTRAINT books_of_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);

CREATE TABLE authors
(
    id SERIAL PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    book_id INT,
    CONSTRAINT book_author
        FOREIGN KEY (book_id)
            REFERENCES books (id)
);

CREATE TABLE book_with_author
(
    id_book INT,
    id_author INT,
    FOREIGN KEY (id_book) REFERENCES books (id),
    FOREIGN KEY (id_author) REFERENCES authors (id)
)