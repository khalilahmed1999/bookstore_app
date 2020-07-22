/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Pocsai Zsolt
 */
public class MainGUIController {
    private BookTilesPane bookTilesPane;
    private NavigatorSideBar navigatorSideBar;
    @FXML private BorderPane topPane;
    @FXML private TextField txtSearch;
    @FXML private ScrollPane scrollPane;
    
    public MainGUIController() {}
    
    @FXML
    private void initialize() {
        bookTilesPane = new BookTilesPane();
        navigatorSideBar = new NavigatorSideBar(bookTilesPane);
        bookTilesPane.setNavigatorSideBar(navigatorSideBar);
        topPane.setLeft(navigatorSideBar);
        scrollPane.setContent(bookTilesPane);
        scrollPane.setFitToWidth(true);
        txtSearch.setFocusTraversable(false);
    }
    
    private void update() {
        navigatorSideBar.update(navigatorSideBar.getCurrentCategory());
        bookTilesPane.update();
    }
    
    @FXML
    private void clickShowCart() {
        Dialog cartDialog = new Dialog("fxml/CartGUI.fxml", "Cart");
        cartDialog.show();
    }
    
    @FXML
    private void clickOrdersManager() {
        Dialog ordersManager = new Dialog("fxml/OrdersManagerGUI.fxml", "Orders Manager");
        ordersManager.showAndWait();
    }
    
    @FXML
    private void clickOpenCategoryManager() {
        Dialog categoryManager = new Dialog("fxml/CategoryManagerGUI.fxml", "Category Manager");
        categoryManager.showAndWait();
        update();
    }
    
    @FXML
    private void clickTop5() {
        bookTilesPane.showTOP5(navigatorSideBar.getCurrentCategory());
    }
    
    @FXML
    private void clickSearch() {
        if (txtSearch.getText().equals("")) return;
        
        bookTilesPane.search(txtSearch.getText());
    }
    
    @FXML
    private void clickShowNewBooks() {
        bookTilesPane.showNewBooks();
    }
    
    @FXML
    private void clickOpenBookDataManager() {
        Dialog bookDataManager = new Dialog("fxml/BookDataManagerGUI.fxml", "Book Data Manager");
        bookDataManager.showAndWait();
        update();
    }
}
