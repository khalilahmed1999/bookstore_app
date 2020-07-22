/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import javafx.stage.Stage;

/**
 *
 * @author Pocsai Zsolt
 */
public class GUIController {
    private Stage dialog = null;
    protected BookStoreController controller =
            BookStoreControllerImpl.getInstance();
    
    protected void setDialog(Stage stage) {
        this.dialog = stage;
    }
    
    protected void closeDialog() {
        if (dialog != null) dialog.close();
    }
}
