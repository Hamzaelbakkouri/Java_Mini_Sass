package Models;

import DataBase.DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BookModel {
    private String Title;
    Statement statement = null;
    private String author;
    private String status;
    private double ISBN;

    public BookModel() {
        this.statement = new DB().connect();
    }

    void setTitle(String title) {
        Title = title;
    }

    void setAuthor(String Author) {
        author = Author;
    }

    void setISBN(double isbn) {
        ISBN = isbn;
    }

    void setStatus(String Status) {
        status = Status;
    }

    String getTitle() {
        return Title;
    }

    String getAuthor() {
        return author;
    }

    double getISBN() {
        return ISBN;
    }

    String getStatus() {
        return status;
    }

    void insertBook() {
        try {
            this.statement.executeQuery("INSERT INTO books (title, createdate, ISBN, author) VALUES (" + getTitle() + ", " + getcreateDate() + ", " + getISBN() + ", " + getAuthor() + ");");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    void FindBookByTitle() {
        try {
            this.statement.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
