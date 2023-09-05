package interfaces;

import bookjava.Book;

import java.sql.SQLException;
import java.util.List;

public interface bookDAO extends DAO<Book> {
    Book getOne(int id) throws SQLException;

    List<Book> getByAuthor(String author) throws SQLException;

    Book getOneByIsbn(String isbn) throws SQLException;

    List<Book> getAll() throws SQLException;

    Book insert(Book Book) throws SQLException;

    Book update(Book Book) throws SQLException;

    int delete(Book Book) throws SQLException;
}
