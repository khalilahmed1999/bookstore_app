/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Cart;
import bookstore.model.CartItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Pocsai Zsolt
 */
public class CartDialogController extends GUIController {
    private Cart cartInstance = Cart.getInstance();
    @FXML private ListView<CartItem> lstvwCartItems;
    @FXML private TextField txtAmount;
    
    public CartDialogController() {
        
    }
    
    @FXML
    private void initialize() {
        update();
    }
    
    private void update() {
        lstvwCartItems.getItems().clear();
        for (CartItem item : cartInstance.getItems()) {
            lstvwCartItems.getItems().add(item);
        }
    }
    
    @FXML
    private void clickDelete() {
        CartItem item = lstvwCartItems.getSelectionModel().getSelectedItem();
        cartInstance.getItems().remove(item);
        update();
    }
    
    @FXML
    private void clickChange() {
        if (!txtAmount.getText().equals("")) {
                int amount;
            try {
                amount = Integer.valueOf(txtAmount.getText());
            } catch (NumberFormatException e) {
                new MessageDialog("Invalid input!");
                return;
            }
            lstvwCartItems.getSelectionModel().getSelectedItem().
                    setAmount(amount);
            update();
        }
    }
    
    @FXML
    private void clickOrder() {
        Dialog order = new Dialog("fxml/OrderDialogGUI.fxml", "Order");
        order.showAndWait();
        update();
    }
}
