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
public interface OrderDAO {
    
    public ArrayList<Order> getAllOrders();
    public int addOrder(Order order);
    public int setStateOfOrder(int orderNumber, String state);
    public int deleteOrder(int orderNumber);
    
    public ArrayList<OrderItem> getAllOrderItems();
    public ArrayList<OrderItem> getOrderItems(int orderNumber);
    public int addOrderItem(OrderItem orderItem);
}
