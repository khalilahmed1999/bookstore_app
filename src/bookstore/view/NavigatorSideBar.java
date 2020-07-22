/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import bookstore.model.Category;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pocsai Zsolt
 */
public class NavigatorSideBar extends VBox{
    private BookTilesPane bookTilesPane;
    private Label lblStateInfo = new Label();
    private VBox vbxButtonHolder = new VBox();
    private BookStoreController controller = 
            BookStoreControllerImpl.getInstance();
    
    public NavigatorSideBar(BookTilesPane bookTilesPane) {
        this.getChildren().addAll(lblStateInfo, vbxButtonHolder);
        this.bookTilesPane = bookTilesPane;
        
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setAlignment(Pos.TOP_CENTER);
        this.setPrefWidth(230);
        lblStateInfo.setPadding(new Insets(10, 0, 10, 0));
        vbxButtonHolder.setSpacing(5);
        vbxButtonHolder.setAlignment(Pos.CENTER);
        
        initialize();
    }
    
    private void initialize() {
        Button tempButton;
        
        vbxButtonHolder.getChildren().clear();
        
        String buttonText;
        int numberOfBooks;
        for (Category category : controller.getAllCategories()) {
            if (category.getParent() == null) {
                buttonText = category.getName();
                numberOfBooks = controller.getNumberOfBooksInCategory(category.getName());
                if (numberOfBooks > 0) {
                    buttonText = buttonText.concat(" (" + numberOfBooks + ")");
                }
                tempButton = new Button(buttonText);
                tempButton.setOnAction(
                        new clickCategoryButton(category.getName()));
                tempButton.setPrefWidth(180);
                vbxButtonHolder.getChildren().add(tempButton);
            }
        }
        
        lblStateInfo.setText("Main categories");
        bookTilesPane.initialize();
    }
    
    public String getCurrentCategory() {
        if (lblStateInfo.getText().equals("Main categories")) {
            return "";
        } else {
            return lblStateInfo.getText();
        }
    }
    
    class clickBackButton implements EventHandler<ActionEvent> {
        Category parent;
        
        clickBackButton(Category parent) {
            this.parent = parent;
        }
        
        @Override
        public void handle(ActionEvent e) {
            if (parent != null) {
                update(parent.getName());
            } else {
                initialize();
            }
        }
    }
    
    class clickCategoryButton implements EventHandler<ActionEvent> {
        String categoryName;
        
        clickCategoryButton(String categoryName) {
            this.categoryName = categoryName;
        }
        
        @Override
        public void handle(ActionEvent e) {
            update(categoryName);
        }
    }
    
    public void update(String categoryName) {
        ArrayList<Category> categories = controller.getAllCategories();
        Category actualCategory = null;
        Button tempButton;
        
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                actualCategory = category;
                break;
            }
        }
        if (actualCategory == null) {
            initialize();
            return;
        }
        
        vbxButtonHolder.getChildren().clear();
        
        tempButton = new Button("Back");
        tempButton.setOnAction(new clickBackButton(actualCategory.getParent()));
        tempButton.setPrefWidth(180);
        vbxButtonHolder.getChildren().add(tempButton);
        
        int numberOfBooks;
        String buttonText;
        for (Category category : actualCategory.getSubcategories()) {
            buttonText = category.getName();
            numberOfBooks = controller.getNumberOfBooksInCategory(category.getName());
            if (numberOfBooks > 0) {
                buttonText = buttonText.concat(" (" + numberOfBooks + ")");
            }
            tempButton = new Button(buttonText);
            tempButton.setOnAction(new clickCategoryButton(category.getName()));
            tempButton.setPrefWidth(180);
            vbxButtonHolder.getChildren().add(tempButton);
        }
        
        lblStateInfo.setText(categoryName);
        bookTilesPane.update();
    }
}
