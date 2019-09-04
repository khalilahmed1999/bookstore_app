/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author Pocsai Zsolt
 */
public class AddPublisherDialogController extends GUIController {
    @FXML private TextField txtPublisher;
    
    @FXML
    private void uploadPublisher(ActionEvent e) {
        String publisherName;
        
        publisherName = txtPublisher.getText();
        if (controller.addPublisher(publisherName) > 0) {
            try {
                closeDialog();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        } else {
            new MessageDialog("Upload was not successfull!");
        }
    }
}
