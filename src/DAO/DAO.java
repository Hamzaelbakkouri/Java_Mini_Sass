package DAO;

import bookjava.book;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(int id) throws SQLException;

    List<T> getALL() throws SQLException;

    T insert(T t) throws SQLException;

    T update(T t) throws SQLException;

    int delete(T t) throws SQLException;
}
