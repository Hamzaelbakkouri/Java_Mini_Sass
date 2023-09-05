package implemente;
import bookjava.Book;
import interfaces.bookDAO;

import java.sql.SQLException;
import java.util.List;

public class implBook implements bookDAO {

    @Override
    public List<Book> getALL() throws SQLException {
        return null;
    }

    @Override
    public Book getOne(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Book> getByAuthor(String author) throws SQLException {
        return null;
    }

    @Override
    public Book getOneByIsbn(String isbn) throws SQLException {
        return null;
    }

    @Override
    public List<Book> getAll() throws SQLException {
        return null;
    }

    @Override
    public Book insert(Book Book) throws SQLException {
        return null;
    }

    @Override
    public Book update(Book Book) throws SQLException {
        return null;
    }

    @Override
    public int delete(Book Book) throws SQLException {
        return 0;
    }
}
