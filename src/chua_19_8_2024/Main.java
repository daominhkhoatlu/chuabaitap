package chua_19_8_2024;

import chua_19_8_2024.entites.Book;
import chua_19_8_2024.entites.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        //
        Book book1 = new Book("JavaCore", "XXX", "1");
        Book book2 = new Book("SpringBoot", "YYY", "2");
        Book book3 = new Book("AWS", "ZZZ", "3");
        Book book4 = new Book("Azure", "BBB", "4");

        //
        lib.addBook(book1);
        lib.addBook(book2);
        lib.addBook(book3);
        lib.addBook(book4);
        System.out.println("Size of lib: " + lib.getBooks().size());

        lib.displayBook();

        //
        String input;
        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the isbn of the book: ");
            String isbn = sc.nextLine();

            System.out.println("Enter the borrower the book: ");
            String borrower = sc.nextLine();
            try {
                lib.borrowBook(isbn, borrower);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println("Enter Y/N: ");
            input = sc.nextLine();
        } while (!input.equalsIgnoreCase("N"));

        //
        lib.displayStatusLibrary();

        //
        System.out.println("=== Bat dau tra sach=====");


        do {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter the isbn of the book: ");
            String isbn = sc.nextLine();
            lib.returnBook(isbn);
            System.out.println("Enter Y/N: ");
            input = sc.nextLine();
        } while (!input.equalsIgnoreCase("N"));

        System.out.println("===== Sau Khi tra sach====");

        lib.displayStatusLibrary();

    }
}
