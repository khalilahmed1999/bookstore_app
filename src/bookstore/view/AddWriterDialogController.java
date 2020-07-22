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
public class AddWriterDialogController extends GUIController{
    @FXML private TextField txtWriter;
    @FXML private Button buttonOK;
    
    @FXML
    private void uploadWriter(ActionEvent e) {
        String writerName;
        
        writerName = txtWriter.getText();
        if (controller.addWriter(writerName) > 0) {
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
