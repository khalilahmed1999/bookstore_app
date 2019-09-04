package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import bookstore.model.Book;
import javafx.geometry.Insets;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BookTile extends VBox {
    Book book;

    public BookTile(Book book) {
        this.book = book;
        initialize();
    }

    private void initialize() {
        BookStoreController controller = BookStoreControllerImpl.getInstance();
        Label lblTitle = new Label(book.getTitle());
        Label lblPrice = new Label();
        Label lblAuthors = new Label();
        Button btnShow = new Button("Show");
        String authors;
        
        authors = controller.getAuthorsOfBook(book.getIsbn()).getAuthorsLabel();
        lblAuthors.setText(authors);
        
        lblPrice.setText(book.getPrice() + " Ft");
        
        this.getChildren().addAll(lblTitle, lblAuthors, lblPrice, btnShow);
        this.setPadding(new Insets(5));
        this.setSpacing(5);
        this.setMinWidth(150);
        this.setBorder(new Border(new BorderStroke(Color.BLACK, 
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, 
                new BorderWidths(1))));
        BookTile.setMargin(btnShow, new Insets(5, 0, 0, 0));
        btnShow.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                new ShowBookDialog(book);
                BookTilesPane parent = (BookTilesPane)BookTile.this.getParent();
                parent.update();
            }
        });
    }
}