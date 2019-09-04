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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pocsai Zsolt
 */
public class ModifyBookController extends GUIController {
    private Book book;
    @FXML private VBox vbxRoot;
    @FXML private Label lblIsbn;
    @FXML private TextField txtTitle;
    @FXML private ComboBox<String> cmbPublisher;
    @FXML private TextField txtYearOfPublish;
    @FXML private ComboBox<String> cmbCategory;
    @FXML private TextField txtNumberOfPages;
    @FXML private TextField txtPrice;
    private AddAuthorsControl ctrlAuthors;
    
    public ModifyBookController() {}
    
    public void setBook(Book book) {
        this.book = book;
        
        lblIsbn.setText("ISBN: " + book.getIsbn());
        txtTitle.setText(book.getTitle());
        cmbPublisher.setValue(book.getPublisher());
        txtYearOfPublish.setText(String.valueOf(book.getYearOfPublish()));
        cmbCategory.setValue(book.getCategory());
        txtNumberOfPages.setText(String.valueOf(book.getNumberOfPages()));
        txtPrice.setText(String.valueOf(book.getPrice()));
        
        for (String author : controller.
                getAuthorsOfBook(book.getIsbn()).getAuthors()) {
            
            ctrlAuthors.getValues().add(author);
        }
        
        update();
    }
    
    @FXML
    private void initialize() {
        ctrlAuthors = new AddAuthorsControl();
        vbxRoot.getChildren().add(vbxRoot.getChildren().indexOf(txtTitle) + 1, ctrlAuthors);
    }
    
    private void update() {
        
        cmbPublisher.getItems().clear();
        cmbCategory.getItems().clear();
        
        for (String publisher : controller.getAllPublishers()) {
            cmbPublisher.getItems().add(publisher);
        }
        for (Category category : controller.getAllCategories()) {
            cmbCategory.getItems().add(category.getName());
        }
        ctrlAuthors.update();
    }
    
    private Book createNewBook() throws NumberFormatException {
        Book newBook;
        Long isbn = book.getIsbn();
        String title = txtTitle.getText();
        String publisher = cmbPublisher.getValue();
        int yearOfPublish = Integer.valueOf(txtYearOfPublish.getText());
        String category = cmbCategory.getValue();
        int numberOfPages;
        if (!txtNumberOfPages.getText().equals("")) {
            numberOfPages = Integer.valueOf(txtNumberOfPages.getText());
        } else {
            numberOfPages = 0;
        }
        int price;
        if (!txtPrice.getText().equals("")) {
            price = Integer.valueOf(txtPrice.getText());
        } else {
            price = 0;
        }

        newBook = new Book(isbn, title, publisher, yearOfPublish, category,
                numberOfPages, price);
        
        return newBook;
    }
    
    private AuthorsOfBook createAOB() {
        AuthorsOfBook newAOB = new AuthorsOfBook(book.getIsbn());
        for (String author : ctrlAuthors.getValues()) {
            newAOB.getAuthors().add(author);
        }
        return newAOB;
    }
    
    @FXML 
    private void clickCancel() {
        closeDialog();
    }
    
    @FXML
    private void clickOK() {
        Book newBook = null;
        
        try {
            newBook = createNewBook();
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        
        if (newBook != null && 
                controller.modifyBook(book.getIsbn(), newBook) != -1 &&
                controller.modifyAuthorsOfBook(createAOB()) != -1) {
            
            closeDialog();
        } else {
            new MessageDialog("Modifing the book was not successfull!");
        }
    }
    
    @FXML
    private void clickAddNewPublisher() {
        Dialog addPublisherDialog = new Dialog("fxml/AddPublisherGUI.fxml", "New Publisher");
        addPublisherDialog.showAndWait();
        update();
    }
    
    @FXML
    private void clickAddNewCategory() {
        Dialog addCategory = new Dialog("fxml/AddCategoryGUI.fxml", "Add category");
        addCategory.showAndWait();
        update();
    }
}
