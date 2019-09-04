/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Cart;
import bookstore.model.CartItem;
import bookstore.model.Order;
import bookstore.model.OrderItem;
import bookstore.util.OrderStatesEnum;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeSet;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Pocsai Zsolt
 */
public class OrderDialogController extends GUIController{
    private Cart cart = Cart.getInstance();
    @FXML private ListView<CartItem> lstvwOrderItems;
    @FXML private TextField txtName;
    @FXML private TextField txtPhone;
    @FXML private TextField txtAddress;
    @FXML private TextField txtEmail;
    
    @FXML
    private void initialize() {
        update();
    }
    
    private void update() {
        for (CartItem item : cart.getItems()) {
            lstvwOrderItems.getItems().add(item);
        }
    }
    
    private boolean areFieldsOK() {
        if (lstvwOrderItems.getItems().size() != 0 &&
                !txtName.getText().equals("") &&
                !txtPhone.getText().equals("") &&
                !txtAddress.getText().equals("") &&
                !txtEmail.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }
    
    private int generateOrderNumber() {
        TreeSet<Integer> orderNumbers = new TreeSet<>();
        for (Order order : controller.getAllOrders()) {
            orderNumbers.add(order.getOrderNumber());
        }
        int orderNumber;
        if (!orderNumbers.isEmpty()) {
            orderNumber = orderNumbers.last() + 1;
        } else {
            orderNumber = 1;
        }
        return orderNumber;
    }
    
    private Order assembleOrder(int orderNumber) {
        Order order;
        
        if (!areFieldsOK()) return null;
        
        order = new Order(
                orderNumber, 
                txtName.getText(), 
                txtPhone.getText(),
                txtEmail.getText(), 
                txtAddress.getText(), 
                null,
                OrderStatesEnum.New
        );
        
        return order;
    }
    
    private ArrayList<OrderItem> assembleOrderItems(int orderNumber) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        
        if (cart.getItems().isEmpty()) return null;
        
        for (CartItem item : cart.getItems()) {
            orderItems.add(new OrderItem(orderNumber, 
                    item.getBook().getIsbn(), item.getAmount()));
        }
        
        return orderItems;
    }
    
    @FXML
    private void clickSendOrder() {
        int orderNumber = generateOrderNumber();
        Order order;
        ArrayList<OrderItem> orderItems;

        order = assembleOrder(orderNumber);
        orderItems = assembleOrderItems(orderNumber);
        
        if (order == null) {
            new MessageDialog("Empty field!");
            return;
        } else if (orderItems == null) {
            new MessageDialog("There is nothing in your cart!");
            return;
        }
        
        boolean allGood = true;
        if (controller.addOrder(order) > 0) {
            for (OrderItem item : orderItems) {
                if (controller.addOrderItem(item) <= 0) {
                    allGood = false;
                    break;
                }
            }
        } else {
            allGood = false;
        }
        
        if (allGood) {
            cart.getItems().clear();
            closeDialog();
        } else {
            new MessageDialog("Storing data was not successfull");
        }
    }
    
    @FXML
    private void clickCancel() {
        closeDialog();
    }
}
