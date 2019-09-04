package bookstore.view;

import bookstore.model.Book;


public class ShowBookDialog extends Dialog {
    
    public ShowBookDialog(Book book) {
        super("fxml/ShowBookDialogGUI.fxml", "Book");
        ShowBookDialogController dialogController = fxmlLoader.getController();
        dialogController.setBook(book);
        this.show();
    }
}