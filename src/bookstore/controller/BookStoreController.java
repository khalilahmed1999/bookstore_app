package bookstore.controller;

import bookstore.model.AuthorsOfBook;
import java.util.ArrayList;
import bookstore.model.Category;
import bookstore.model.Book;
import bookstore.model.Order;
import bookstore.model.OrderItem;
import bookstore.model.Publisher;
import bookstore.model.SumOfSoldBookByWriter;
import bookstore.model.Writer;

public interface BookStoreController {

    public int startConnection();
    public void killConnection();

    public ArrayList<Category> getAllCategories();
    public int addCategory(Category category);
    public int getNumberOfBooksInCategory(String categoryName);
    public int deleteCategory(String categoryName);
    public int modifyCategory(String categoryName, Category newCategory);
    public ArrayList<Category> getCategoriesWithBookCount();
    
    public ArrayList<Book> getAllBooks();
    public ArrayList<Book> getBooksOfCategory(String categoryName);
    public int addBook(Book book);
    public int modifyBook(long isbn, Book newBook);
    public int deleteBook(long isbn);
    public ArrayList<Book> getBooksBySearch(String keyword);
    public Book getBookByISBN(long isbn);
    public ArrayList<Book> getBooksByPopularity(String category);
    public ArrayList<Book> getNewestBooks();
    
    public AuthorsOfBook getAuthorsOfBook(long isbn);
    public int addAuthorsOfBook(AuthorsOfBook authorsOfBook);
    public int modifyAuthorsOfBook(AuthorsOfBook newAOB);
    
    public ArrayList<String> getAllWriters();
    public int addWriter(String writerName);
    public int deleteWriter(String writerName);
    public int modifyWriter(String writerName, String newName);
    
    public ArrayList<Writer> getWritersWithSoldBooks();
    public ArrayList<Writer> getAllWriterAsObject();
    public ArrayList<SumOfSoldBookByWriter> getListOfSoldBooksByWriter();
    
    public ArrayList<Publisher> getAllPublishersAsObject();
    public ArrayList<String> getAllPublishers();
    public int addPublisher(String publisherName);
    public int deletePublisher(String publisherName);
    public int modifyPublisher(String publisherName, String newName);
    
    public ArrayList<Order> getAllOrders();
    public int addOrder(Order order);
    public int setStateOfOrder(int orderNumber, String state);
    public int deleteOrder(int orderNumber);
    
    public ArrayList<OrderItem> getAllOrderItems();
    public int addOrderItem(OrderItem orderItem);
}