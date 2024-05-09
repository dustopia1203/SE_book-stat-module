package model;

import java.util.ArrayList;
import java.util.Date;

public class Borrowing {
    private int id;
    private Date borrowDate;
    private Date expectedPayDate;
    private int totalAmount;
    private String note;
    private Reader reader;
    private ArrayList<BorrowedBook> borrowedBooks;

    public Borrowing() {
    }

    public Borrowing(int id, Date borrowDate, Date expectedPayDate, int totalAmount, String note, Reader reader, ArrayList<BorrowedBook> borrowedBooks) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.expectedPayDate = expectedPayDate;
        this.totalAmount = totalAmount;
        this.note = note;
        this.reader = reader;
        this.borrowedBooks = borrowedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getExpectedPayDate() {
        return expectedPayDate;
    }

    public void setExpectedPayDate(Date expectedPayDate) {
        this.expectedPayDate = expectedPayDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public ArrayList<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<BorrowedBook> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
