package implemente;

import DataBase.DB;
import bookjava.Book;
import interfaces.bookDAO;
import interfaces.status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class implBook implements bookDAO {

    @Override
    public List<Book> getALL() throws SQLException {
        Connection connection = DB.Connect();
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String title = rs.getString("title");
            double ISBN = rs.getDouble("ISBN");
            String createdate = rs.getString("createdate");
            String author = rs.getString("author");
            String status = rs.getString("status");

            Book book = new Book(ISBN, title, author, createdate, status);
            books.add(book);
        }

        rs.close();
        ps.close();
        connection.close();

        return books;
    }


    @Override
    public Book getOne(String Title) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT * FROM books WHERE title = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, Title);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String title = rs.getString("title");
            double ISBN = rs.getDouble("ISBN");
            String author = rs.getString("author");
            String createdate = rs.getString("createdate");
            String status = rs.getString("status");

            Book book = new Book(ISBN, title, author, createdate, status);
            return book;
        }
        rs.close();
        ps.close();
        connection.close();
        return null;
    }

    @Override
    public List<Book> getByAuthor(String author) throws SQLException {
        Connection connection = DB.Connect();
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE author LIKE ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, '%' + author + '%');
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String title = rs.getString("title");
            double ISBN = rs.getDouble("ISBN");
            String createdate = rs.getString("createdate");
            String Author = rs.getString("author");
            String status = rs.getString("status");

            Book book = new Book(ISBN, title, Author, createdate, status);
            books.add(book);
        }

        rs.close();
        ps.close();
        connection.close();

        return books;
    }

    @Override
    public List<Book> getBooksByStatus(String status) throws SQLException {
        Connection connection = DB.Connect();
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE status = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, status);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String title = rs.getString("title");
            double ISBN = rs.getDouble("ISBN");
            String createdate = rs.getString("createdate");
            String Status = rs.getString("status");
            String author = rs.getString("author");

            Book book = new Book(ISBN, title, author, createdate, Status);
            books.add(book);
        }

        rs.close();
        ps.close();
        connection.close();

        return books;
    }


    @Override
    public Book getOneByIsbn(double isbn) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT * FROM books WHERE ISBN = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setDouble(1, isbn);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String title = rs.getString("title");
            String author = rs.getString("author");
            String createdate = rs.getString("createdate");
            String status = rs.getString("status");

            Book book = new Book(isbn, title, author, createdate, status);
            return book;
        }
        rs.close();
        ps.close();
        connection.close();
        Book bk = getOneByIsbn(isbn);
        if (bk == null) {
            System.out.println("book not found");
            return null;
        }
        return bk;
    }

    @Override
    public Book updateBookStatut(Book book) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "UPDATE books SET status = ? WHERE ISBN = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, book.getStatus());
        ps.setDouble(2, book.getISBN());
        int rs = ps.executeUpdate();

        ps.close();
        connection.close();
        Book bk = getOneByIsbn(book.getISBN());
        if (bk == null) {
            System.out.println("book not found");
            return null;
        }
        return bk;
    }


    @Override
    public Book insert(Book Book) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "INSERT INTO books (title , createdate , ISBN , author , status) VALUES ( ? , ? , ? , ? , ? )";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, Book.getTitle());
        ps.setString(2, Book.getCreateDate());
        ps.setDouble(3, Book.getISBN());
        ps.setString(4, Book.getAuthor());
        ps.setString(5, Book.getStatus());

        int rs = ps.executeUpdate();

        ps.close();
        connection.close();
        Book bk = getOneByIsbn(Book.getISBN());
        if (bk == null) {
            System.out.println("book not found");
            return null;
        }
        return bk;
    }

    @Override
    public Book update(Book Book) throws SQLException {
        Connection connection = DB.Connect();
        String sql = "UPDATE books SET title = ? , createdate = ? , author = ? , status = ? WHERE ISBN = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, Book.getTitle());
        ps.setString(2, Book.getCreateDate());
        ps.setString(3, Book.getAuthor());
        ps.setString(4, Book.getStatus());
        ps.setDouble(5, Book.getISBN());

        int rs = ps.executeUpdate();

        ps.close();
        connection.close();
        Book bk = getOneByIsbn(Book.getISBN());
        if (bk == null) {
            System.out.println("book not found");
            return null;
        }
        return bk;
    }

    @Override
    public boolean delete(double isbn) throws SQLException {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean last = false;
        try {
            connection = DB.Connect();
            String sql = "DELETE FROM books WHERE ISBN = ? AND status <> ?";
            ps = connection.prepareStatement(sql);
            ps.setDouble(1, isbn);
            ps.setString(2, String.valueOf(status.enprunté));

            int rowCount = ps.executeUpdate();

            if (rowCount == 0) {
                last = false;
            } else {
                last = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return last;
    }

    @Override
    public Integer StatistiqueDisponible() throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT COUNT(*) FROM books WHERE status = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.valueOf(status.disponible));
        ResultSet rs = ps.executeQuery();

        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }

        rs.close();
        ps.close();
        connection.close();
        return rowCount;
    }


    @Override
    public Integer StatistiqueLost() throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT COUNT(*) FROM books WHERE status = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.valueOf(status.perdu));
        ResultSet rs = ps.executeQuery();

        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }

        rs.close();
        ps.close();
        connection.close();
        return rowCount;
    }

    @Override
    public Integer StatistiqueBorrow() throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT COUNT(*) FROM books WHERE status = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, String.valueOf(status.enprunté));
        ResultSet rs = ps.executeQuery();

        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        ps.close();
        connection.close();
        return rowCount;
    }

    @Override
    public Integer AllBooks() throws SQLException {
        Connection connection = DB.Connect();
        String sql = "SELECT COUNT(*) FROM books";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        int rowCount = 0;
        if (rs.next()) {
            rowCount = rs.getInt(1);
        }
        rs.close();
        ps.close();
        connection.close();
        return rowCount;
    }


}
