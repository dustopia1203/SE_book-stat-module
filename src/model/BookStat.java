package model;

public class BookStat extends Book {
    private String status;
    private int totalBorrowing;

    public BookStat() {
    }

    public BookStat(int id, String name, String author, String gendre, String publisher, int publicYear, int totalBorrowing, String status) {
        super(id, name, author, gendre, publisher, publicYear);
        this.totalBorrowing = totalBorrowing;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalBorrowing() {
        return totalBorrowing;
    }

    public void setTotalBorrowing(int totalBorrowing) {
        this.totalBorrowing = totalBorrowing;
    }
}
