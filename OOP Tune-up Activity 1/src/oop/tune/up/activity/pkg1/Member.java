/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop.tune.up.activity.pkg1;
import java.util.ArrayList;

/**
 *
 * @author student-106
 */
class Member {
    protected String name;
    protected String username;
    protected String password;
    protected ArrayList<Book> borrowedBooks;

    public Member(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getUsername(){
        return username;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public int getBorrowingLimit(){
        return 0;
    }

    public void borrowBook(Book book) {
        if (!book.isAvailable()){
            System.out.println("Book is not available.");
            return;
        }

        if (borrowedBooks.size() >= getBorrowingLimit()){
            System.out.println(name + "has reached the borrowing limit of " + getBorrowingLimit() + "books.");
            return;
        }

        book.setAvailable(false);
        borrowedBooks.add(book);

        System.out.println("\nBook borrowed successfully!");
        System.out.println("Book: " + book.getTitle());
        System.out.println("Books borrowed: " + borrowedBooks.size() + "/" + getBorrowingLimit());
    }

    public void returnBook(Book book) {

        if (!borrowedBooks.contains(book)) {
            System.out.println(
                "You did not borrow this book."
            );
            return;
        }

        borrowedBooks.remove(book);
        book.setAvailable(true);

        System.out.println("\nBook returned successfully!");
        System.out.println("Book: " + book.getTitle());
        System.out.println(
            "Books currently borrowed: "
            + borrowedBooks.size()
        );
    }

    public void viewBorrowedBooks() {

        if (borrowedBooks.isEmpty()) {
            System.out.println("\nYou have no borrowed books.");
            return;
        }

        System.out.println("\n===== MY BORROWED BOOKS =====");

        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println(
                (i + 1) + ". " + borrowedBooks.get(i).getTitle()
            );
        }
    }
}
