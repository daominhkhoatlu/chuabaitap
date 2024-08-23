package chua_19_8_2024.entites;

import chua_19_8_2024.repository.BookRepository;

import java.util.*;

public class Library implements BookRepository {
    private List<Book> books = new ArrayList<>();
    private Set<String> borrowedIsbnBooks = new HashSet<>();
    //<isbn, ten nguoi muon>
    Map<String, String> borrowedBy = new HashMap<>();

    public Map<String, String> getBorrowedBy() {
        return borrowedBy;
    }

    public Set<String> getBorrowedIsbnBooks() {
        return borrowedIsbnBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public void addBook(Book newBook) {
        books.add(newBook);

    }

    @Override
    public void borrowBook(String isbn, String borrower) throws Exception {
        //check isbn ton tai
        if (checkIsbnBookExist(isbn)) {
            borrowedBy.put(isbn, borrower);
        } else {
            throw new Exception("muon sach bi loi!!! ");
        }
    }

    @Override
    public void returnBook(String isbn) {
        if (borrowedBy.containsKey(isbn)) {
            borrowedBy.remove(isbn);
        }
    }

    @Override
    public void displayBook() {
        for (Book book : books) {
            borrowedIsbnBooks.add(book.getIsbn());
            System.out.println(book);
        }
    }

    @Override
    public boolean checkIsbnBookExist(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void displayStatusLibrary() {
        System.out.println("Nhung quyen sach da duoc muon: ");
        for (String id : borrowedIsbnBooks) {
            if (borrowedBy.containsKey(id)) {

                // Book 1("JavaCore", "XXX", "1") - Khoa
                System.out.println(id + " - " + borrowedBy.get(id));
            }
        }
    }
}
