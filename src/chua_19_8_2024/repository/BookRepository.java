package chua_19_8_2024.repository;

import chua_19_8_2024.entites.Book;

import java.util.Set;

public interface BookRepository {
    void addBook(Book book);
    void borrowBook(String isbn, String borrower) throws Exception;
    void returnBook(String isbn);
    void displayBook();
    boolean checkIsbnBookExist(String isbn);
    void displayStatusLibrary();
}
