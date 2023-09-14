package interfaces;

import bookjava.Book;
import bookjava.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface BorrowDAO {
    boolean insert(Borrow borrow) throws SQLException;

    void CheckDates() throws SQLException;
}
