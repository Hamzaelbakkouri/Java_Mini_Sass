<<<<<<< HEAD
import DataBase.DB;
import bookjava.Book;
=======
import Controllers.book;
import DataBase.DB;
>>>>>>> d4df0675dad5c2cc9a9fb9070f4e045f0811dfa2

import java.sql.Statement;
import java.util.Scanner;

public class Main {
<<<<<<< HEAD

    public static void PrincipalMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************ WELCOME TO OUR LIBRARY *******************");
        System.out.println("1 : _______________ to create a book ___________________ \n");
=======
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DB db = new DB();


        System.out.println("************ WELCOME TO OUR LIBRARY *******************");
        System.out.println("1 : _______________ to create a book ___________________ \n \n");
>>>>>>> d4df0675dad5c2cc9a9fb9070f4e045f0811dfa2

        System.out.println("Enter a number to implement the function : \n");
        int checker = Integer.parseInt(scanner.nextLine());

        switch (checker) {
            case 1:
<<<<<<< HEAD
                System.out.println("Choice is 1");
=======
                book book = new book();
                book.createBook();
>>>>>>> d4df0675dad5c2cc9a9fb9070f4e045f0811dfa2
                break;

            case 2:
                System.out.println("Choice is 2");
                break;

            case 3:
                System.out.println("Choice is 3");
                break;

            default:
                System.out.println("Choice is not 1, 2, or 3");
                break;
        }
<<<<<<< HEAD

    }
    public static void main(String[] args) {
        DB db = new DB();

=======
>>>>>>> d4df0675dad5c2cc9a9fb9070f4e045f0811dfa2
    }
}