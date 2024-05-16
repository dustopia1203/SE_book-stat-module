package model;

public class BookError {
    private int id;
    private String bookError;

    public BookError() {
    }

    public BookError(int id, String bookError) {
        this.id = id;
        this.bookError = bookError;
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
}
