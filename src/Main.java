import DataBase.DB;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void PrincipalMenu() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************ WELCOME TO OUR LIBRARY *******************");
        System.out.println("1 : ______________ Search For a book _________________ ");
        System.out.println("2 : _______________ Show All Books ___________________  ");
        System.out.println("3 : _______________ Create a Book ____________________  ");
        System.out.println("4 : ___________ Update Or Delete a Book ______________  ");
        System.out.println("5 : _________________ Find Books _____________________  ");

        menu menu = new menu();
        System.out.println("Enter a number to implement the Method : \n");
        int checker = Integer.parseInt(scanner.nextLine());
        switch (checker) {
            case 1:
                menu.getOne();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }
            case 2:
                menu.getAllBooks();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }

            case 3:
                menu.insetBook();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }
            case 4:
                menu.UpdateOrDeleteBook();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }
            case 5:
                menu.getBooksByStatus();
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }
            default:
                System.out.println("Choice Not Found");
                System.out.println("Back to menu click 1 , else to exit :");
                if (Integer.parseInt(scanner.nextLine()) == 1) {
                    PrincipalMenu();
                } else {
                    break;
                }
        }

    }


    public static void main(String[] args) {
        try {
            PrincipalMenu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}