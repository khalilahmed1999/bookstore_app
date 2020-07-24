package bookstore.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


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
