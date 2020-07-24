package bookstore.model;

import bookstore.util.OrderStatesEnum;
import java.sql.Date;


public class Order {
    private final int orderNumber;
    private final String customerName;
    private final String phoneNumber;
    private final String emailAddress;
    private final String deliveryAddress;
    private final Date dateOfOrder;
    private OrderStatesEnum state;
    
    public Order(int orderNumber, String customerName, String phoneNumber,
                 String emailAddress, String deliveryAddress,
                 Date dateOfOrder, OrderStatesEnum state) {
        
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.deliveryAddress = deliveryAddress;
        this.dateOfOrder = dateOfOrder;
        this.state = state;
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    
    public Date getDateOfOrder() {
        return dateOfOrder;
    }
    
    public OrderStatesEnum getState() {
        return state;
    }
    
    public void setState(OrderStatesEnum state) {
        this.state = state;
    }
}
