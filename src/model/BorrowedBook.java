package model;

public class BorrowedBook {
    private int id;
    private String payDate;
    private float deposit;
    private String note;
    private int amount;
    private boolean isBorrowed;
    private Book book;

    public BorrowedBook() {
    }

    public BorrowedBook(int id, String payDate, float deposit, String note, int amount, boolean isBorrowed, Book book) {
        this.id = id;
        this.payDate = payDate;
        this.deposit = deposit;
        this.note = note;
        this.amount = amount;
        this.isBorrowed = isBorrowed;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
