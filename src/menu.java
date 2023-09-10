import DataBase.DB;
import bookjava.Book;
import bookjava.Borrow;
import bookjava.Member;
import implemente.implBook;
import implemente.implBorrow;
import implemente.implMember;
import interfaces.BorrowDAO;
import interfaces.bookDAO;
import interfaces.memberDAO;
import interfaces.status;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class menu {
    //    BOOK PART
    public void getOneBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("search for book with title 1 , with author 2");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            System.out.println("Enter the title : \n");
            String title = scanner.nextLine();
            bookDAO bookdao = new implBook();
            Book book = bookdao.getOne(title);

            System.out.println("\nTitle: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");
        } else if (choice == 2) {
            System.out.println("Enter the author : \n");
            String author = scanner.nextLine();
            bookDAO bookdao = new implBook();
            List<Book> books = bookdao.getByAuthor(author);
            int counter = 1;
            for (Book book : books) {
                System.out.println("Book number " + counter + ":");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Create Date: " + book.getCreateDate());
                System.out.println("Status: " + book.getStatus());
                System.out.println("---------------------------------------");
                counter++;
            }
        }
    }

    public void getBooksByStatus() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 : Disponible \n2 : Enprunté \n3 : Perdu \n");
        int Status = Integer.parseInt(scanner.nextLine());
        String Value = null;
        if (Status == 1) {
            Value = String.valueOf(status.disponible);
        } else if (Status == 2) {
            Value = String.valueOf(status.enprunté);
        } else if (Status == 3) {
            Value = String.valueOf(status.perdu);
        }

        bookDAO bookdao = new implBook();
        List<Book> books = bookdao.getBooksByStatus(Value);
        int counter = 1;
        for (Book book : books) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public void getAllBooks() throws SQLException {
        bookDAO bookdao = new implBook();
        List<Book> books = bookdao.getALL();
        int counter = 1;
        for (Book book : books) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");
            counter++;
        }
    }

    public void insetBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Title : \n");
        String title = scanner.nextLine();

        System.out.println("Enter book create Date : \n");
        String createdate = scanner.nextLine();

        System.out.println("Enter book ISBN : \n");
        double ISBN = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter book author : \n");
        String author = scanner.nextLine();

        String Status = String.valueOf(status.disponible);

        bookDAO bookdao = new implBook();
        Book bk = new Book(ISBN, title, author, createdate, Status);
        Book book = bookdao.insert(bk);

        System.out.println("\nTitle: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Create Date: " + book.getCreateDate());
        System.out.println("Status: " + book.getStatus());
        System.out.println("---------------------------------------");
    }

    public void UpdateOrDeleteBook() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("click 1 to update book , click 2 delete book , else to exit");
        int choice = Integer.parseInt(scanner.nextLine());
        bookDAO bookdao = new implBook();
        List<Book> books = bookdao.getALL();
        int counter = 1;
        for (Book book : books) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");
            counter++;
        }

        if (choice == 1) {
            //update book
            int numbook = Integer.parseInt(scanner.nextLine());
            double isbn = books.get(numbook - 1).getISBN();
            System.out.println("Enter book Title : \n");
            String title = scanner.nextLine();

            System.out.println("Enter book create Date : \n");
            String createdate = scanner.nextLine();

            System.out.println("Enter book author : \n");
            String author = scanner.nextLine();
            System.out.println("1: disponible , 2: perdu");
            int num = Integer.parseInt(scanner.nextLine());
            String Status = String.valueOf(status.disponible);
            if (num == 1) {
                Status = String.valueOf(status.disponible);
            } else if (num == 2) {
                Status = String.valueOf(status.perdu);
            } else {
                Status = String.valueOf(status.disponible);
            }

            Book bk = new Book(isbn, title, author, createdate, Status);
            Book book = bookdao.update(bk);

            System.out.println("\nTitle: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");

        } else if (choice == 2) {
            //delete book
            int numbook = Integer.parseInt(scanner.nextLine());
            double isbn = books.get(numbook - 1).getISBN();
            boolean last = bookdao.delete(isbn);
            if (last == true) {
                System.out.println("Book with ISBN " + isbn + " deleted successfully");
            } else {
                System.out.println("Book with ISBN " + isbn + " not found");
            }
        } else {
            return;
        }
    }
//        MEMBER PART

    public Member getOneMember() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Member CIN : \n");
        String cin = scanner.nextLine();
        memberDAO memberdao = new implMember();
        Member member = memberdao.getOne(cin);
        if (member == null) {
            System.out.println("Member Not Found");
        } else {
            System.out.println("\nid: " + member.getID());
            System.out.println("Name: " + member.getName());
            System.out.println("CIN: " + cin);
            System.out.println("Phone number: " + member.getPhoneNumber());
            System.out.println("---------------------------------------");
        }
        return member;
    }

    public Member insertMember() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter member name : ");
        String name = scanner.nextLine();
        System.out.println("Enter member CIN : ");
        String cin = scanner.nextLine();
        System.out.println("Enter member Phone Number : ");
        String phnenumber = scanner.nextLine();

        Member mb = new Member(name, cin, phnenumber);
        memberDAO memberdao = new implMember();
        Member member = memberdao.insert(mb);
        if (member == null) {
            System.out.println("Member Not Found");
        } else {
            System.out.println("\nid: " + member.getID());
            System.out.println("Name: " + member.getName());
            System.out.println("CIN: " + cin);
            System.out.println("Phone number: " + member.getPhoneNumber());
            System.out.println("---------------------------------------");
        }
        return member;
    }

    //    Borrowing Part
    public void Borrow_a_Book() throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);
        Member member = null;
        System.out.println("already member click 1 , first time Borrow a book click 2");
        int num = Integer.parseInt(scanner.nextLine());
        if (num == 1) {
            member = getOneMember();
        } else if (num == 2) {
            member = insertMember();
        }
        System.out.println("************************* Disponible BOOKS ********************");
        bookDAO bookdao = new implBook();
        List<Book> books = bookdao.getBooksByStatus(String.valueOf(status.disponible));
        int counter = 1;
        for (Book book : books) {
            System.out.println("Book number " + counter + ":");
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Create Date: " + book.getCreateDate());
            System.out.println("Status: " + book.getStatus());
            System.out.println("---------------------------------------");
            counter++;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date borrowDate = new Date(System.currentTimeMillis());
        if (books != null) {
            System.out.println("choose a book");
            int numbook = Integer.parseInt(scanner.nextLine());
            Book book = books.get(numbook - 1);
            System.out.println("Enter return date :");
            String scan = scanner.nextLine();
            Date date = dateFormat.parse(scan);
            java.sql.Date returnDate = new java.sql.Date(date.getTime());
            java.sql.Date nowDate = new java.sql.Date(borrowDate.getTime());

            if (returnDate.after(nowDate)) {

                Borrow br = new Borrow(book, member, nowDate, returnDate);
                BorrowDAO borrowdao = new implBorrow();
                boolean borrowBook = borrowdao.insert(br);
                if (borrowBook) {
                    System.out.println("book borrowed successfully");
                } else {

                    System.out.println("book borrow Failed");
                }
            } else {
                System.out.println(returnDate);
                System.out.println(nowDate);
                System.out.println("enter a date higher than today");
            }
        }
    }
}
