package bookstore.view;

import bookstore.model.Book;
import bookstore.model.Publisher;
import bookstore.model.SumOfSoldBookByWriter;
import bookstore.model.Writer;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class BookDataManagerController extends GUIController {
    @FXML private TableView<Book> tblBooks;
    @FXML private TableView<Writer> tblWriters;
    @FXML private TableView<Publisher> tblPublishers;
    @FXML private TableView<SumOfSoldBookByWriter> tblWritersWithBooks;
    @FXML private Tab tbBooks;
    @FXML private Tab tbWriters;
    @FXML private Tab tbPublishers;
    
    public BookDataManagerController() {}
    
    @FXML
    private void initialize() {
        createTableBooks();
        createTableWriters();
        createTablePublishers();
        createTableWritersWithBooks();
        update();
    }
    
    private void update() {
        //book table
        tblBooks.getItems().clear();
        for (Book book : controller.getAllBooks()) {
            tblBooks.getItems().add(book);
        }
        //writers table
        tblWriters.getItems().clear();
        for (Writer writer : controller.getAllWriterAsObject()) {
            tblWriters.getItems().add(writer);
        }
        //publishers table
        tblPublishers.getItems().clear();
        for (Publisher publisher : controller.getAllPublishersAsObject()) {
            tblPublishers.getItems().add(publisher);
        }
        
        tblWritersWithBooks.getItems().clear();
        for (SumOfSoldBookByWriter item : controller.getListOfSoldBooksByWriter()) {
            tblWritersWithBooks.getItems().add(item);
        }
    }
    
    private void createTableBooks() {
        TableColumn<Book, Long> colIsbn;
        TableColumn<Book, String> colTitle;
        TableColumn<Book, String> colPublisher;
        TableColumn<Book, String> colCategory;
        TableColumn<Book, String> colPrice;
        
        colIsbn = new TableColumn<>("ISBN");
        colIsbn.setCellValueFactory(
                new PropertyValueFactory<>("isbn"));
        colTitle = new TableColumn<>("Title");
        colTitle.setCellValueFactory(
                new PropertyValueFactory<>("title"));
        colPublisher = new TableColumn<>("Publisher");
        colPublisher.setCellValueFactory(
                new PropertyValueFactory<>("publisher"));
        colCategory = new TableColumn<>("Category");
        colCategory.setCellValueFactory(
                new PropertyValueFactory<>("category"));
        colPrice = new TableColumn<>("Price");
        colPrice.setCellValueFactory(
                new PropertyValueFactory<>("priceText"));
        
        tblBooks.getColumns().addAll(colIsbn, colTitle, colPublisher, 
                colCategory, colPrice);
    }
    
    private void createTableWriters() {
        TableColumn<Writer, String> colName;
        
        colName = new TableColumn<>("Name");
        colName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        
        tblWriters.getColumns().addAll(colName);
    }
    
    private void createTablePublishers() {
        TableColumn<Publisher, String> colName;
        
        colName = new TableColumn<>("Name");
        colName.setCellValueFactory(
                new PropertyValueFactory<>("name"));
        
        tblPublishers.getColumns().addAll(colName);
    }
    
    private void createTableWritersWithBooks() {
        TableColumn<SumOfSoldBookByWriter, String> colWriter;
        TableColumn<SumOfSoldBookByWriter, String> colBook;
        TableColumn<SumOfSoldBookByWriter, Integer> colSold;
        
        colWriter = new TableColumn<>("Writer");
        colWriter.setCellValueFactory(
                new PropertyValueFactory<>("writerName"));
        colBook = new TableColumn<>("Book");
        colBook.setCellValueFactory(
                new PropertyValueFactory<>("bookTitle"));
        colSold = new TableColumn<>("Sold");
        colSold.setCellValueFactory(
                new PropertyValueFactory<>("sold"));
        
        tblWritersWithBooks.getColumns().addAll(colWriter, colBook, colSold); 
    }
    
    @FXML
    private void clickAdd() {
        Dialog addDialog = null;
        if (tbBooks.isSelected()) {
            addDialog = new Dialog("fxml/AddBookGUI.fxml", "Add Book");
        } else if (tbWriters.isSelected()) {
            addDialog = new Dialog("fxml/AddWriterGUI.fxml", "Add Writer");
        } else if (tbPublishers.isSelected()) {
            addDialog = new Dialog("fxml/AddPublisherGUI.fxml", "Add Publisher");
        }
        if (addDialog != null) {
            addDialog.showAndWait();
            update();
        }
    }
    
    @FXML
    private void clickModify() {
        Dialog modifyDialog = null;
        if (tbBooks.isSelected()) {
            
            if (tblBooks.getSelectionModel().isEmpty()) return;
            
            modifyDialog = new Dialog("fxml/ModifyBookGUI.fxml", "Modify Book");
            ModifyBookController mbController = 
                    modifyDialog.getFXMLLoader().getController();
            mbController.setBook(tblBooks.getSelectionModel().getSelectedItem());
            
        } else if (tbWriters.isSelected()) {
            return;
        } else if (tbPublishers.isSelected()) {
            return;
        }
        if (modifyDialog != null) {
            modifyDialog.showAndWait();
            update();
        }
    }
    
    @FXML
    private void clickDelete() {
        if (tbBooks.isSelected()) {
            if (tblBooks.getSelectionModel().isEmpty()) return;
            controller.deleteBook(
                    tblBooks.getSelectionModel().getSelectedItem().getIsbn());
        } else if (tbWriters.isSelected()) {
            if (tblWriters.getSelectionModel().isEmpty()) return;
            controller.deleteWriter(
                    tblWriters.getSelectionModel().getSelectedItem().getName());
        } else if (tbPublishers.isSelected()) {
            if (tblPublishers.getSelectionModel().isEmpty()) return;
            controller.deletePublisher(
                    tblPublishers.getSelectionModel().getSelectedItem().getName());
        }
        update();
    }
}
