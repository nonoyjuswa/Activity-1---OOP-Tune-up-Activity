/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.tune.up.activity.pkg1;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author student-106
 */

public class OOPTuneUpActivity1 {

    /**
     * @param args the command line arguments
     */
    // TODO code application logic here
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Member> members = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args) {

        // Sample books
        books.add(new Book("Java Programming"));
        books.add(new Book("Object-Oriented Programming"));
        books.add(new Book("Database Systems"));
        books.add(new Book("Computer Networks"));
        books.add(new Book("Software Engineering"));

        while (true) {

            System.out.println("\n===== LIBRARY BORROWING SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    Member loggedInUser = login();

                    if (loggedInUser != null) {
                        userMenu(loggedInUser);
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Library System!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // =========================
    // REGISTER
    // =========================
    public static void register() {

        System.out.println("\n===== REGISTER =====");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check duplicate username
        for (Member member : members) {
            if (member.getUsername().equals(username)) {
                System.out.println("Username already exists.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("\nSelect account type:");
        System.out.println("1. Student");
        System.out.println("2. Faculty");
        System.out.print("Choice: ");

        int type = scanner.nextInt();
        scanner.nextLine();

        Member newMember;

        if (type == 1) {
            newMember = new Student(name, username, password);
        } else if (type == 2) {
            newMember = new Faculty(name, username, password);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        members.add(newMember);

        System.out.println("\nRegistration successful!");
        System.out.println("You can now login.");
    }

    // =========================
    // LOGIN
    // =========================
    public static Member login() {

        System.out.println("\n===== LOGIN =====");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        for (Member member : members) {

            if (member.getUsername().equals(username)
                    && member.checkPassword(password)) {

                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + member.name + "!");

                return member;
            }
        }

        System.out.println("\nInvalid username or password.");
        return null;
    }

    // =========================
    // USER MENU
    // =========================
    public static void userMenu(Member member) {

        while (true) {

            System.out.println("\n===== USER MENU =====");
            System.out.println("Welcome, " + member.name);
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View My Borrowed Books");
            System.out.println("5. Logout");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    viewBooks();
                    break;

                case 2:
                    borrowBook(member);
                    break;

                case 3:
                    returnBook(member);
                    break;

                case 4:
                    member.viewBorrowedBooks();
                    break;

                case 5:
                    System.out.println(
                        "Logged out successfully."
                    );
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // VIEW ALL BOOKS
    public static void viewBooks() {

        System.out.println("\n===== BOOKS =====");

        for (int i = 0; i < books.size(); i++) {

            Book book = books.get(i);

            System.out.println(
                (i + 1)
                + ". "
                + book.getTitle()
                + " - "
                + (book.isAvailable()
                    ? "Available"
                    : "Borrowed")
            );
        }
    }

    // BORROW BOOK
    public static void borrowBook(Member member) {

        viewBooks();

        System.out.print("\nEnter book number to borrow: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();

        if (bookNumber < 1 || bookNumber > books.size()) {

            System.out.println("Invalid book number.");
            return;
        }

        Book selectedBook = books.get(bookNumber - 1);

        member.borrowBook(selectedBook);
    }

    // UNBORROW BOOK
    public static void returnBook(Member member) {

        member.viewBorrowedBooks();

        if (member.borrowedBooks.isEmpty()) {
            return;
        }

        System.out.print(
            "\nEnter book number to return: "
        );

        int bookNumber = scanner.nextInt();
        scanner.nextLine();

        if (bookNumber < 1
                || bookNumber > member.borrowedBooks.size()) {

            System.out.println("Invalid book number.");
            return;
        }

        Book selectedBook =
            member.borrowedBooks.get(bookNumber - 1);

        member.returnBook(selectedBook);
    }
}
