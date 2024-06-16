package model;

public class BookStat extends Book {
    private String status;
    private int totalBorrowing;
    private float totalRevenue;

    public BookStat() {
    }

    public BookStat(int id, String name, String author, String gendre, String publisher, int publicYear, float rentPerDay, float price, String status, int totalBorrowing, float totalRevenue) {
        super(id, name, author, gendre, publisher, publicYear, rentPerDay, price);
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

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public int getTotalBorrowing() {
        return totalBorrowing;
    }

    public void setTotalBorrowing(int totalBorrowing) {
        this.totalBorrowing = totalBorrowing;
    }
}
