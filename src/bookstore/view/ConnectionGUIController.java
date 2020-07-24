/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.controller.BookStoreControllerImpl;
import bookstore.model.ConnectionBuilder;
import java.sql.Connection;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Pocsai Zsolt
 */
public class ConnectionGUIController extends GUIController{
    @FXML private TextField txtUsername;
    @FXML private TextField txtPassword;
    
    public ConnectionGUIController() {}
    
    @FXML
    private void clickConnect() {
        if (createConnection() > 0) {
            new MessageDialog("Connection is created!");
            closeDialog();
        } else {
            new MessageDialog("Failed to connect to database.");
        }
    }
    
    private int createConnection() {
        BookStoreControllerImpl bsci = BookStoreControllerImpl.getInstance();
        Connection conn = null;
        try {
            //conn = ConnectionBuilder.buildConnection(txtUsername.getText(), txtPassword.getText());
        	conn = ConnectionBuilder.buildConnection();
        } catch (SQLException e) {
            System.err.println(e);
            return -1;
        }
        if (conn != null) {
            bsci.setConnection(conn);
            return 1;
        } else {
            return -1;
        }
    }
}
