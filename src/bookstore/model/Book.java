package bookstore.model;

import java.sql.Date;

public class Book {
    private long isbn;
    private String title;
    private String publisher;
    private int yearOfPublish;
    private String category;
    private int numberOfPages = 0;
    private int price = 0;
    private Date dateOfRegistration;

    public Book(long isbn, String title, String publisher, int yearOfPublish,
        String category, int numberOfPages, int price) {

        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.yearOfPublish = yearOfPublish;
        this.category = category;
        this.numberOfPages = numberOfPages;
        this.price = price;
        this.dateOfRegistration = new Date(new java.util.Date().getTime());
    }

    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public int getYearOfPublish() {
        return yearOfPublish;
    }
    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    public int getPrice() {
        return price;
    }
    public String getPriceText() {
        return price + " Ft";
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }
    public void setDateOfRegistration(Date date) {
        this.dateOfRegistration = date;
    }
}