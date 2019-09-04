/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Pocsai Zsolt
 */
public class MessageDialogController extends GUIController{
    @FXML private Label lblMessage;
    
    @FXML
    private void clickOK() {
        closeDialog();
    }
    
    public void setMessage(String message) {
        lblMessage.setText(message);
    }
}
