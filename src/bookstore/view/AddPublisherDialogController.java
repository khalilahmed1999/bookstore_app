package bookstore.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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
