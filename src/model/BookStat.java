package model;

public class BookStat extends Book {
    private String status;
    private int totalBorrowing;
    private float totalRevenue;

    public BookStat() {
    }

    public BookStat(int id, String name, String author, String gendre, String publisher, int publicYear, String status, int totalBorrowing, float totalRevenue) {
        super(id, name, author, gendre, publisher, publicYear);
        this.status = status;
        this.totalBorrowing = totalBorrowing;
        this.totalRevenue = totalRevenue;
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

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
