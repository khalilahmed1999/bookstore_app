/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.view;

import bookstore.model.AuthorsOfBook;
import bookstore.model.Book;
import bookstore.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pocsai Zsolt
 */
public class AddBookDialogController extends GUIController {
    @FXML private VBox vbxRoot; 
    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitle;
    @FXML private TextField txtYearOfPublish;
    @FXML private TextField txtNumberOfPages;
    @FXML private TextField txtPrice;
    @FXML private ComboBox<String> cmbPublisher;
    @FXML private ComboBox<String> cmbCategory;
    private AddAuthorsControl ctrlAuthors;
    
    public AddBookDialogController() {
        ctrlAuthors = new AddAuthorsControl();
    }
    
    @FXML
    private void initialize() {
        vbxRoot.getChildren().add(vbxRoot.getChildren().indexOf(txtTitle) + 1, ctrlAuthors);
        update();
    }
    
    private void update() {
        ctrlAuthors.update();
        
        cmbPublisher.getItems().clear();
        cmbCategory.getItems().clear();
        
        for (String publisher : controller.getAllPublishers()) {
            cmbPublisher.getItems().add(publisher);
        }
        for (Category category : controller.getAllCategories()) {
            cmbCategory.getItems().add(category.getName());
        }
    }
    
    private int addAuthors(long isbn) {
        AuthorsOfBook authorsOfBook = new AuthorsOfBook(isbn);
        for (String author : ctrlAuthors.getValues()) {
            authorsOfBook.getAuthors().add(author);
        }
        return controller.addAuthorsOfBook(authorsOfBook);
    }
    
    @FXML
    private void clickAddBook() {
        Book book = null;
        long isbn; 
        int yearOfPublish;
        int numberOfPages = 0;
        int price = 0;
        String title, publisher, category;

        try {
            isbn = Long.parseLong(txtIsbn.getText());
            title = txtTitle.getText();
            publisher = cmbPublisher.getValue();
            yearOfPublish = Integer.parseInt(txtYearOfPublish.getText());
            category = cmbCategory.getValue();
            
            if (!txtNumberOfPages.getText().equals("")) {
                numberOfPages = Integer.parseInt(txtNumberOfPages.getText());
            }
            
            if (!txtPrice.getText().equals("")) {
                price = Integer.parseInt(txtPrice.getText());
            }
            
            book = new Book(isbn, title, publisher, yearOfPublish, category,
                    numberOfPages, price);
            
        } catch (NumberFormatException e) {
            System.err.println(e);
        } catch (Exception e) {
            System.err.println(e);
        }
        
        if (book != null && controller.addBook(book) > 0 &&
                addAuthors(book.getIsbn()) > 0) {
            closeDialog();
        } else {
            new MessageDialog("Upload was not successfull!");
        }
    }
    
    @FXML
    private void clickCancel() {
        closeDialog();
    }
    
    @FXML
    private void clickAddNewCategory() {
        Dialog addCategory = new Dialog("fxml/AddCategoryGUI.fxml", "New Category");
        addCategory.showAndWait();
        update();
    }
    
    @FXML
    private void clickAddPublisher() {
        Dialog addPublisher = new Dialog("fxml/AddPublisherGUI.fxml", "New Publisher");
        addPublisher.showAndWait();
        update();
    }
}
