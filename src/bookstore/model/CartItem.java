/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

/**
 *
 * @author Pocsai Zsolt
 */
public class CartItem {
    private Book book;
    private int amount;
    
    public CartItem(Book book, int amount) {
        this.book = book;
        this.amount = amount;
    }
    
    public CartItem(Book book) {
        this(book, 1);
    }
    
    public Book getBook() {
        return book;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public String toString() {
        return book.getTitle() + ", " + book.getPrice() + " Ft, " +
                amount + "db";
    }
}
