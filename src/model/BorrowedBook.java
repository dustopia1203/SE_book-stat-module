package model;

import java.util.ArrayList;
import java.util.Date;

public class BorrowedBook {
    private int id;
    private float deposit;
    private String note;
    private int amount;
    private Book book;
    private Date payDate;
    private ArrayList<BookError> bookErrors;

    public BorrowedBook() {
    }

    public BorrowedBook(int id, float deposit, String note, int amount, Book book, Date payDate, ArrayList<BookError> bookErrors) {
        this.id = id;
        this.deposit = deposit;
        this.note = note;
        this.amount = amount;
        this.book = book;
        this.payDate = payDate;
        this.bookErrors = bookErrors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public ArrayList<BookError> getBookErrors() {
        return bookErrors;
    }

    public void setBookErrors(ArrayList<BookError> bookErrors) {
        this.bookErrors = bookErrors;
    }
}
