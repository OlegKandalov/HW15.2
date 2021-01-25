package org.cursor15.dao;

public interface LibraryCRUD <T> {
    void create(T t);

    T getById(int id);

    void update(T t);

    void delete(T t);


}
