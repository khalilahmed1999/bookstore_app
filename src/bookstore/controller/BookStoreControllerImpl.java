package bookstore.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import bookstore.model.*;
import bookstore.view.Dialog;

public class BookStoreControllerImpl implements BookStoreController {
    private static BookStoreControllerImpl instance;
    private Connection dbConn;
    private CategoryDAO categoryDAO;
    private BookDAO bookDAO;
    private AuthorsOfBookDAO authorsOfBookDAO;
    private OrderDAO orderDAO;
    private WriterDAO writerDAO;

    static {
        instance = new BookStoreControllerImpl();
    }

    private BookStoreControllerImpl() {}

    public static BookStoreControllerImpl getInstance() {
        return instance;
    }

    // It was used only with the oracle database
    public void setConnection(Connection conn) {
        dbConn = conn;
    }
    
    // It was used only with the oracle database
    public int startConnection_old() {
        Dialog connectionDialog = new Dialog("fxml/ConnectionGUI.fxml", "Create connection");
        connectionDialog.showAndWait();
        
        if (dbConn == null) return -1;
        
        categoryDAO = new CategoryDAOImpl(dbConn);
        bookDAO = new BookDAOImpl(dbConn);
        authorsOfBookDAO = new AuthorsOfBookDAOImpl(dbConn);
        orderDAO = new OrderDAOImpl(dbConn);
        writerDAO = new WriterDAOImpl(dbConn);
        
        return 1;
    }
    
    public int startConnection() {
    	Statement stmt;
    	String sql;
    	
        try {
        	dbConn = ConnectionBuilder.buildConnection();
        	
        	// Enable foreign key support in SQLite
            sql = "PRAGMA foreign_keys = ON";
            stmt = dbConn.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println(e);
            return -1;
        }
        
        categoryDAO = new CategoryDAOImpl(dbConn);
        bookDAO = new BookDAOImpl(dbConn);
        authorsOfBookDAO = new AuthorsOfBookDAOImpl(dbConn);
        orderDAO = new OrderDAOImpl(dbConn);
        writerDAO = new WriterDAOImpl(dbConn);
        
        return 1;
    }

    public void killConnection() {
        if (dbConn == null) return;
        
        try {
            dbConn.close();
            System.out.println("Connection is closed.");
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }
    
    @Override
    public int addCategory(Category category) {
        return categoryDAO.addCategory(category);
    }
    
    @Override
    public int getNumberOfBooksInCategory(String categoryName) {
        return categoryDAO.getNumberOfBooksInCategory(categoryName);
    }
    
    @Override
    public int modifyCategory(String categoryName, Category newCategory) {
        return categoryDAO.modifyCategory(categoryName, newCategory);
    }
    
    @Override
    public int deleteCategory(String categoryName) {
        return categoryDAO.deleteCategory(categoryName);
    }
    
    @Override
    public ArrayList<Category> getCategoriesWithBookCount() {
        return categoryDAO.getCategoriesWithBookCount();
    }

//------------------------------------------------------------------------------

    @Override
    public ArrayList<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }
    
    @Override
    public ArrayList<Book> getBooksOfCategory(String categoryName) {
        return bookDAO.getBooksOfCategory(categoryName);
    }
    
    @Override
    public int addBook(Book book) {
        return bookDAO.addBook(book);
    }
    
    @Override
    public int modifyBook(long isbn, Book newBook) {
        return bookDAO.modifyBook(isbn, newBook);
    }
    
    @Override
    public int deleteBook(long isbn) {
        return bookDAO.deleteBook(isbn);
    }
    
    @Override
    public ArrayList<Book> getBooksBySearch(String keyword) {
        return bookDAO.getBooksBySearch(keyword);
    }
    
    @Override
    public Book getBookByISBN(long isbn) {
        return bookDAO.getBookByISBN(isbn);
    }
    
    @Override
    public ArrayList<Book> getBooksByPopularity(String category) {
        return bookDAO.getBooksByPopularity(category);
    }
    
    @Override
    public ArrayList<Book> getNewestBooks() {
        return bookDAO.getNewestBooks();
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public AuthorsOfBook getAuthorsOfBook(long isbn) {
        return authorsOfBookDAO.getAuthorsOfBook(isbn);
    }
    
    @Override
    public int addAuthorsOfBook(AuthorsOfBook authorsOfBook) {
        return authorsOfBookDAO.addAuthorsOfBook(authorsOfBook);
    }
    
    @Override
    public int modifyAuthorsOfBook(AuthorsOfBook newAOB) {
        return authorsOfBookDAO.modifyAuthorsOfBook(newAOB);
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<String> getAllWriters() {
        return bookDAO.getAllWriters();
    }
    
    @Override
    public int addWriter(String writerName) {
        return bookDAO.addWriter(writerName);
    }
    
    @Override
    public int deleteWriter(String writerName) {
        return bookDAO.deleteWriter(writerName);
    }
    
    @Override
    public int modifyWriter(String writerName, String newName) {
        return bookDAO.modifyWriter(writerName, newName);
    }
    
    @Override
    public ArrayList<Writer> getWritersWithSoldBooks() {
        return writerDAO.getWritersWithSoldBooks();
    }
    
    @Override
    public ArrayList<Writer> getAllWriterAsObject() {
        return writerDAO.getAllWriter();
    }
    
    @Override
    public ArrayList<SumOfSoldBookByWriter> getListOfSoldBooksByWriter() {
        return writerDAO.getListOfSoldBooksByWriter();
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<Publisher> getAllPublishersAsObject() {
        return bookDAO.getAllPublishersAsObject();
    }
    
    @Override
    public ArrayList<String> getAllPublishers() {
        return bookDAO.getAllPublishers();
    }
    
    @Override
    public int addPublisher(String publisherName) {
        return bookDAO.addPublisher(publisherName);
    }
    
    @Override
    public int deletePublisher(String publisherName) {
        return bookDAO.deletePublisher(publisherName);
    }
    
    @Override
    public int modifyPublisher(String publisherName, String newName) {
        return bookDAO.modifyPublisher(publisherName, newName);
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }
    
    @Override
    public int addOrder(Order order) {
        return orderDAO.addOrder(order);
    }
    
    @Override
    public int setStateOfOrder(int orderNumber, String state) {
        return orderDAO.setStateOfOrder(orderNumber, state);
    }
    
    @Override
    public int deleteOrder(int orderNumber) {
        return orderDAO.deleteOrder(orderNumber);
    }
    
    @Override
    public int addOrderItem(OrderItem orderItem) {
        return orderDAO.addOrderItem(orderItem);
    }
    
    @Override
    public ArrayList<OrderItem> getAllOrderItems() {
        return orderDAO.getAllOrderItems();
    }
}