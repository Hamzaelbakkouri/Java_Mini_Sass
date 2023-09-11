package interfaces;


import bookjava.Book;

import java.sql.SQLException;
import java.util.List;

public interface bookDAO extends DAO<Book> {

    Book getOne(String title) throws SQLException;

    List<Book> getByAuthor(String author) throws SQLException;

    List<Book> getBooksByStatus(String status) throws SQLException;

    Book getOneByIsbn(double isbn) throws SQLException;

    Book updateBookStatut(Book book) throws SQLException;

    List<Book> getALL() throws SQLException;

    Integer StatistiqueDisponible() throws SQLException;

    Integer StatistiqueLost() throws SQLException;

    Integer AllBooks() throws SQLException;

    Integer StatistiqueBorrow() throws SQLException;

    Book insert(Book Book) throws SQLException;

    Book update(Book Book) throws SQLException;

    boolean delete(double isbn) throws SQLException;
}
