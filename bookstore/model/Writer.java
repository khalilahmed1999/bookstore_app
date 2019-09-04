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
public class Writer {
    private String name;
    private int numberOfSoldBooks = 0;
    
    public Writer(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    public int getNumberOfSoldBooks() {
        return numberOfSoldBooks;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setNumberOfSoldBooks(int number) {
        numberOfSoldBooks = number;
    }
}
