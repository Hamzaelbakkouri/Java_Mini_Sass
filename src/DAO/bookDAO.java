package DAO;

import bookjava.book;

import java.sql.SQLException;
import java.util.List;

public interface bookDAO extends DAO<book> {
    book get(int id) throws SQLException;

    List<book> getALL() throws SQLException;

    book insert(book Book) throws SQLException;

    book update(book Book) throws SQLException;

    int delete(book Book) throws SQLException;
}
