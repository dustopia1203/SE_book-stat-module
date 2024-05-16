package model;

import java.util.ArrayList;
import java.util.Date;

public class PayTicket {
    private int id;
    private Date payDate;
    private float compensate;
    private ArrayList<Book> borrowedBooks;

    public PayTicket() {
    }

    public PayTicket(int id, Date payDate, float compensate, ArrayList<Book> borrowedBooks) {
        this.id = id;
        this.payDate = payDate;
        this.compensate = compensate;
        this.borrowedBooks = borrowedBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public float getCompensate() {
        return compensate;
    }

    public void setCompensate(float compensate) {
        this.compensate = compensate;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
