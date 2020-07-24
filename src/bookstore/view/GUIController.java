package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import javafx.stage.Stage;


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
