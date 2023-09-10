package interfaces;

import bookjava.Borrow;
import bookjava.Member;

import java.sql.SQLException;
import java.util.List;

public interface BorrowDAO {
    Borrow getOne(String cin) throws SQLException;

    boolean insert(Borrow borrow) throws SQLException;

    Borrow BorrowReturn(Borrow borrow) throws SQLException;

    Borrow update(Borrow borrow) throws SQLException;

}
