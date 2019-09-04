/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.util.ArrayList;

/**
 *
 * @author Pocsai Zsolt
 */
public class Cart {
    private static Cart instance;
    private ArrayList<CartItem> items;
    
    static {
        instance = new Cart();
    }
    
    private Cart() {
        items = new ArrayList<>();
    }
    
    public static Cart getInstance() {
        return instance;
    }
    
    public ArrayList<CartItem> getItems() {
        return items;
    }
}
