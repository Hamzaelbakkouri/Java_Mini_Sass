package bookjava;


public class Book {
    private double ISBN;
    private String Title;
    private String author;
    private String createDate;
    private String status;

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
