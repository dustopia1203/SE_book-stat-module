package model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String gendre;
    private String publisher;
    private int publicYear;
    private float rentPerDay;
    private float price;

    public Book() {
    }

    public Book(int id, String name, String author, String gendre, String publisher, int publicYear, float rentPerDay, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.gendre = gendre;
        this.publisher = publisher;
        this.publicYear = publicYear;
        this.rentPerDay = rentPerDay;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    public float getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(float rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

