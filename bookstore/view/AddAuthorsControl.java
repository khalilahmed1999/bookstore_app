/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pocsai Zsolt
 */
public class AddAuthorsControl extends VBox {
    private BookStoreController controller =
            BookStoreControllerImpl.getInstance();
    private ArrayList<String> authors = new ArrayList<>();
    @FXML private VBox vbxAuthors;
    @FXML private ComboBox<String> cmbWriter;
    
    public AddAuthorsControl() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("fxml/AddAuthorsControlGUI.fxml"));
        
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            System.err.println("Error: at creating AddAuthorsControl");
            System.err.println(e);
        }
    }
    
    @FXML
    private void initialize() {
        update();
    }
    
    public void update() {
        vbxAuthors.getChildren().clear();
        for (String author : authors) {
            vbxAuthors.getChildren().add(new Label(author));
        }
        
        cmbWriter.getItems().clear();
        for (String writer : controller.getAllWriters()) {
            cmbWriter.getItems().add(writer);
        }
        
        
    }
    
    public ArrayList<String> getValues() {
        return authors;
    }
    
    @FXML
    private void clickAddNewWriter() {
        Dialog addWriterDialog = new Dialog("fxml/AddWriterGUI.fxml", "Add Writer");
        addWriterDialog.showAndWait();
        update();
    }
    
    @FXML
    private void clickAddAuthor() {
        if (!cmbWriter.getValue().equals("")) {
            authors.add(cmbWriter.getValue());
        }
        update();
        getScene().getWindow().sizeToScene();
    }
    
    @FXML
    private void clickClear() {
        authors.clear();
        update();
        getScene().getWindow().sizeToScene();
    }
}
