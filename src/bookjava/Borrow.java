package bookjava;

import java.sql.Date;

public class Borrow {
    private Book Book;
    private Member Member;
    private Date BorrowDate;
    private Date returnDate;

    public Borrow(Book Book, Member Member, Date BorrowDate, Date returnDate) {
        this.Book = Book;
        this.Member = Member;
        this.BorrowDate = BorrowDate;
        this.returnDate = returnDate;
    }

    void setBook(Book book) {
        Book = book;
    }

    void setMember(Member member) {
        Member = member;
    }

    void setCIN(Date borrowDate) {
        BorrowDate = borrowDate;
    }

    void setPhoneNumber(Date ReturnDate) {
        returnDate = ReturnDate;
    }


    public Book getBook() {
        return Book;
    }

    public Member getMember() {
        return Member;
    }

    public Date getBorrowDate() {
        return BorrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
