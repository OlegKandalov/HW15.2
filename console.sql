CREATE DATABASE library;

CREATE TABLE users
(
    id INT PRIMARY KEY,
    user_name VARCHAR(255) NOT NULL
);

CREATE TABLE authors
(
    id INT PRIMARY KEY,
    author_name VARCHAR(255) NOT NULL,
    book_id INT
);

CREATE TABLE books
(
    id INT PRIMARY KEY,
    book_title VARCHAR(255) NOT NULL,
    user_id INT,
    author_id INT,
    FOREIGN KEY (author_id)
        REFERENCES authors (id),
    CONSTRAINT books_of_user
        FOREIGN KEY (user_id)
            REFERENCES users (id)
);
