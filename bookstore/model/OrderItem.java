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
public class OrderItem {
    private int orderNumber;
    private long isbn;
    private int amountOfItem;
    
    public OrderItem(int orderNumber, long isbn, int amountOfItem) {
        this.orderNumber = orderNumber;
        this.isbn = isbn;
        this.amountOfItem = amountOfItem;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public long getIsbn() {
        return isbn;
    }
    
    public int getAmountOfItem() {
        return amountOfItem;
    }
    
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    
    public void setAmountOfItem(int amountOfItem) {
        this.amountOfItem = amountOfItem;
    }
}
