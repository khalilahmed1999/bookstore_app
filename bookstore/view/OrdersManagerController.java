/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Order;
import bookstore.model.OrderItem;
import bookstore.model.Writer;
import bookstore.util.OrderStatesEnum;
import java.sql.Date;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Pocsai Zsolt
 */
public class OrdersManagerController extends GUIController {
    @FXML private TableView<Order> tblOrders;
    @FXML private TableView<OrderItem> tblOrderItems;
    @FXML private TableView<Writer> tblSoldBooksByAuthors;
    @FXML private ComboBox<String> cmbState;
    
    @FXML
    private void initialize() {
        createOrdersTable();
        createOrderItemsTable();
        createSoldBooksByAuthorsTable();
        for (OrderStatesEnum value : OrderStatesEnum.values()) {
            cmbState.getItems().add(value.toString());
        }
        update();
    }
    
    private void update() {
        //update orders
        tblOrders.getItems().clear();
        for (Order order : controller.getAllOrders()) {
            tblOrders.getItems().add(order);
        }
        //update order items
        tblOrderItems.getItems().clear();
        for (OrderItem orderItem : controller.getAllOrderItems()) {
            tblOrderItems.getItems().add(orderItem);
        }
        //update sold books by authors
        tblSoldBooksByAuthors.getItems().clear();
        for (Writer writer : controller.getWritersWithSoldBooks()) {
            tblSoldBooksByAuthors.getItems().add(writer);
        }
    }
    
    private void createOrdersTable() {
        TableColumn<Order, Integer> colOrderNumber;
        TableColumn<Order, String> colCustomerName;
        TableColumn<Order, Long> colPhoneNumber;
        TableColumn<Order, String> colEmailAddress;
        TableColumn<Order, String> colDeliveryAddress;
        TableColumn<Order, Date> colDateOfOrder;
        TableColumn<Order, OrderStatesEnum> colState;
    
        colOrderNumber = new TableColumn<>("Order Number");
        colOrderNumber.setCellValueFactory(
                new PropertyValueFactory<>("orderNumber"));
        
        colCustomerName = new TableColumn<>("Customer");
        colCustomerName.setCellValueFactory(
                new PropertyValueFactory<>("customerName"));
        
        colPhoneNumber = new TableColumn<>("Phone");
        colPhoneNumber.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber"));
        
        colEmailAddress = new TableColumn<>("E-mail");
        colEmailAddress.setCellValueFactory(
                new PropertyValueFactory<>("emailAddress"));
        
        colDeliveryAddress = new TableColumn<>("Address");
        colDeliveryAddress.setCellValueFactory(
                new PropertyValueFactory<>("deliveryAddress"));
        
        colDateOfOrder = new TableColumn<>("Date");
        colDateOfOrder.setCellValueFactory(
                new PropertyValueFactory<>("dateOfOrder"));
        
        colState = new TableColumn<>("State");
        colState.setCellValueFactory(
                new PropertyValueFactory<>("state"));
        
        tblOrders.getColumns().addAll(colOrderNumber, 
                colCustomerName, colPhoneNumber, colEmailAddress,
                colDeliveryAddress, colDateOfOrder, colState);
    }
    
    private void createOrderItemsTable() {
        TableColumn<OrderItem, Integer> colOrderNumber;
        TableColumn<OrderItem, Long> colIsbn;
        TableColumn<OrderItem, Integer> colAmount;
        
        colOrderNumber = new TableColumn<>("Order Number");
        colOrderNumber.setCellValueFactory(
                new PropertyValueFactory<>("orderNumber"));
        
        colIsbn = new TableColumn<>("ISBN");
        colIsbn.setCellValueFactory(
                new PropertyValueFactory<>("isbn"));
        
        colAmount = new TableColumn<>("Amount");
        colAmount.setCellValueFactory(
                new PropertyValueFactory<>("amountOfItem"));
        
        tblOrderItems.getColumns().addAll(colOrderNumber,
                colIsbn, colAmount);
    }
    
    private void createSoldBooksByAuthorsTable() {
        TableColumn<Writer, String> colName;
        TableColumn<Writer, Integer> colNumberOfBooks;
        
        colName = new TableColumn<>("Author");
        colName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        
        colNumberOfBooks = new TableColumn<>("Sold Books");
        colNumberOfBooks.setCellValueFactory(
                new PropertyValueFactory<>("numberOfSoldBooks"));
        
        tblSoldBooksByAuthors.getColumns().addAll(colName, colNumberOfBooks);
    }
    
    @FXML
    private void clickSetState() {
        int orderNumber;
        if (!tblOrders.getSelectionModel().isEmpty() &&
                !cmbState.getValue().equals("")) {
            
            orderNumber = tblOrders.getSelectionModel().
                    getSelectedItem().getOrderNumber();
        } else {
            return;
        }
        controller.setStateOfOrder(orderNumber, cmbState.getValue());
        update();
    }
    
    @FXML
    private void clickDeleteOrder() {
        int orderNumber;
        if (!tblOrders.getSelectionModel().isEmpty()) {
            orderNumber = tblOrders.getSelectionModel().
                    getSelectedItem().getOrderNumber();
        } else {
            return;
        }
        controller.deleteOrder(orderNumber);
        update();
    }
}
