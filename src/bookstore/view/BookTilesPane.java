/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.controller.BookStoreController;
import bookstore.controller.BookStoreControllerImpl;
import bookstore.model.Book;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

/**
 *
 * @author Pocsai Zsolt
 */
public class BookTilesPane extends TilePane {
    private final BookStoreController controller = 
            BookStoreControllerImpl.getInstance();
    private NavigatorSideBar navigatorSideBar = null;
    
    public BookTilesPane() {
        this.setPadding(new Insets(10));
        this.setHgap(5);
        this.setVgap(5);
    }
    
    public void initialize() {
        this.getChildren().clear();
    }
    
    public void setNavigatorSideBar(NavigatorSideBar nsb) {
        navigatorSideBar = nsb;
    }
    
    public void update() {
        String categoryName = "";
        
        try {
            categoryName = navigatorSideBar.getCurrentCategory();
        } catch (NullPointerException e) {
            System.err.println("Navigator Side Bar is not set!");
            return;
        }
        
        if (categoryName.equals("")) {
            initialize();
            return;
        }
        
        ArrayList<Book> books = controller.getBooksOfCategory(categoryName);
        
        this.getChildren().clear();
        
        for (Book book : books) {
            this.getChildren().add(new BookTile(book));
        }
    }
    
    public void showTOP5(String categoryName) {
        ArrayList<Book> books = controller.getBooksByPopularity(categoryName);
        
        this.getChildren().clear();
        
        Label top5 = new Label("TOP 5 books by popularity");
        this.getChildren().add(top5);
        
        for (Book book : books) {
            this.getChildren().add(new BookTile(book));
        }
    }
    
    public void search(String keyword) {
        ArrayList<Book> books = controller.getBooksBySearch(keyword);
        
        this.getChildren().clear();
        
        Label foundBooks = new Label("Found Books: " + books.size());
        this.getChildren().add(foundBooks);
        
        for (Book book : books) {
            this.getChildren().add(new BookTile(book));
        }
    }
    
    public void showNewBooks() {
        ArrayList<Book> books = controller.getNewestBooks();
        
        this.getChildren().clear();
        
        this.getChildren().add(new Label("Our newest books!"));
        
        for (Book book : books) {
            this.getChildren().add(new BookTile(book));
        }
    }
}
