package bookjava;

import java.sql.Date;

public class Book {
    private double ISBN;
    private String Title;
    private String author;
    private Date createDate;
    private String status;

    public Book(double isbn, String title, String Author, Date Createdate, String Status) {
        this.Title = title;
        this.ISBN = isbn;
        this.author = Author;
        this.createDate = Createdate;
        this.status = Status;
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

    void setCreateDate(Date CreateDate) {
        createDate = CreateDate;
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

    Date getCreateDate() {
        return createDate;
    }

    String getStatus() {
        return status;
    }
}
