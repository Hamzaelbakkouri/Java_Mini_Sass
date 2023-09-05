import DataBase.DB;
import bookjava.Book;

import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void PrincipalMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("************ WELCOME TO OUR LIBRARY *******************");
        System.out.println("1 : _______________ to create a book ___________________ \n");

        System.out.println("Enter a number to implement the function : \n");
        int checker = Integer.parseInt(scanner.nextLine());

        switch (checker) {
            case 1:
                System.out.println("Choice is 1");
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

    }
    public static void main(String[] args) {
        DB db = new DB();

    }
}