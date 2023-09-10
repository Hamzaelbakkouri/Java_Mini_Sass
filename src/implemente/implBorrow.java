package implemente;

import DataBase.DB;
import bookjava.Book;
import bookjava.Borrow;
import interfaces.BorrowDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class implBorrow implements BorrowDAO {
    @Override
    public Borrow getOne(String cin) throws SQLException {
        return null;
    }

    @Override
    public boolean insert(Borrow borrow) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "INSERT INTO borrowbook (id_book , id_membre , date_emprunt , date_retour ) VALUES ( ? , ? , ? , ? )";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1, borrow.getBook().getISBN());
        ps.setInt(2, borrow.getMember().getID());
        ps.setDate(3, borrow.getBorrowDate());
        ps.setDate(4, borrow.getReturnDate());

        int rs = ps.executeUpdate();
        ps.close();
        connection.close();
        return rs == 1;
    }

    @Override
    public Borrow BorrowReturn(Borrow borrow) throws SQLException {
        return null;
    }

    @Override
    public Borrow update(Borrow borrow) throws SQLException {
        return null;
    }
}
