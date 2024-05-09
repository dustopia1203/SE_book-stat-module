package model;

import java.util.ArrayList;

public class PayTicket {
    private int id;
    private String bookError;
    private float compensate;
    private ArrayList<BorrowedBook> borrowedBooks;

    public PayTicket() {
    }

    public PayTicket(int id, String bookError, float compensate, ArrayList<BorrowedBook> borrowedBooks) {
        this.id = id;
        this.bookError = bookError;
        this.compensate = compensate;
        this.borrowedBooks = borrowedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookError() {
        return bookError;
    }

    public void setBookError(String bookError) {
        this.bookError = bookError;
    }

    public float getCompensate() {
        return compensate;
    }

    public void setCompensate(float compensate) {
        this.compensate = compensate;
    }

    public ArrayList<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<BorrowedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
