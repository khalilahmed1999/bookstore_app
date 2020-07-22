/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

/**
 *
 * @author Pocsai Zsolt
 */
public class MessageDialog extends Dialog {
    
    public MessageDialog(String message) {
        super("fxml/MessageDialog.fxml");
        MessageDialogController controller;
        controller = getFXMLLoader().getController();
        controller.setMessage(message);
        showAndWait();
    }
}
