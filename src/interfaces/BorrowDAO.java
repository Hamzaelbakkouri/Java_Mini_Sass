package interfaces;

import bookjava.Book;
import bookjava.Borrow;
import bookjava.Member;

import java.sql.SQLException;
import java.util.List;

public interface BorrowDAO {
    boolean insert(Borrow borrow) throws SQLException;

    List<Book> CheckDates() throws SQLException;

}
