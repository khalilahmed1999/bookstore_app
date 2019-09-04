
package bookstore.view;

import bookstore.model.Book;
import bookstore.model.Cart;
import bookstore.model.CartItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ShowBookDialogController extends GUIController {
    private Book book;
    @FXML private Label lblIsbn;
    @FXML private Label lblTitle;
    @FXML private Label lblAuthors;
    @FXML private Label lblPublisher;
    @FXML private Label lblYearOfPublish;
    @FXML private Label lblNumberOfPages;
    @FXML private Label lblPrice;
    
    public ShowBookDialogController() {
        
    }
    
    public void setBook(Book book) {
        this.book = book;
        update();
    }
    
    private void update() {
        book = controller.getBookByISBN(book.getIsbn());
        lblIsbn.setText("ISBN: " + String.valueOf(book.getIsbn()));
        lblTitle.setText(book.getTitle());
        lblAuthors.setText(controller.getAuthorsOfBook(book.getIsbn()).
                getAuthorsLabel());
        lblPublisher.setText("Publisher: " + book.getPublisher());
        lblYearOfPublish.setText("Published in " + String.valueOf(book.getYearOfPublish()));
        lblNumberOfPages.setText("Pages: " + String.valueOf(book.getNumberOfPages()));
        lblPrice.setText(String.valueOf(book.getPrice()) + " Ft");
    }
    
    @FXML
    private void clickCancel() {
        closeDialog();
    }
    
    @FXML
    private void clickAddToCart() {
        Cart.getInstance().getItems().add(new CartItem(book));
    }
}