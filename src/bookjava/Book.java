package bookjava;


import java.util.List;

public class Book {
    private double ISBN;
    private String Title;
    private String author;
    private String createDate;
    private String status;
    private List<Borrow> BorrowBook;

    public Book(double isbn, String title, String Author, String Createdate, String Status) {
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
//    void setAuthor(List Author) {
//        BorrowBook;
//    }

    void setISBN(double isbn) {
        ISBN = isbn;
    }

    void setStatus(String Status) {
        status = Status;
    }

    void setCreateDate(String CreateDate) {
        createDate = CreateDate;
    }


    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return author;
    }

    public double getISBN() {
        return ISBN;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getStatus() {
        return status;
    }
}
