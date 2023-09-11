package implemente;

import DataBase.DB;
import bookjava.Book;
import bookjava.Borrow;
import interfaces.BorrowDAO;
import interfaces.bookDAO;
import interfaces.status;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class implBorrow implements BorrowDAO {

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
    public List<Book> CheckDates() throws SQLException {
        Connection connection = DB.Connect();
        List<Double> isbn = new ArrayList<>();

        String sql = "SELECT b.ISBN, bb.* FROM books b INNER JOIN borrowbook bb ON bb.id_book = b.ISBN WHERE (bb.id) IN( SELECT MAX(id) AS max_id FROM borrowbook GROUP BY id_book, id_membre ) AND bb.date_retour < CURRENT_TIMESTAMP()";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            isbn.add(rs.getDouble("ISBN"));
        }

        String Query = "UPDATE `books` SET `status` = ? WHERE `books`.`ISBN` = ?";

        for (Double id : isbn) {
            ps = connection.prepareStatement(Query);
            ps.setString(1, String.valueOf(status.perdu));
            ps.setDouble(2, id);
            int rs9 = ps.executeUpdate();
        }

        bookDAO bookdao = new implBook();
        List<Book> books = bookdao.getBooksByStatus(String.valueOf(status.perdu));
        return books;
    }

}
