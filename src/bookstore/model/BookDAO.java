package bookstore.model;

import java.util.ArrayList;

public interface BookDAO {

    public ArrayList<Book> getAllBooks();
    public ArrayList<Book> getBooksOfCategory(String categoryName);
    public int addBook(Book book);
    public int deleteBook(long isbn);
    public int modifyBook(long isbn, Book newBook);
    public ArrayList<Book> getBooksBySearch(String keyword);
    public Book getBookByISBN(long isbn);
    public ArrayList<Book> getBooksByPopularity(String category);
    public ArrayList<Book> getNewestBooks();
    
    public ArrayList<String> getAllWriters();
    public int addWriter(String writerName);
    public int deleteWriter(String writerName);
    public int modifyWriter(String writerName, String newName);
    
    public ArrayList<Publisher> getAllPublishersAsObject();
    public ArrayList<String> getAllPublishers();
    public int addPublisher(String publisherName);
    public int deletePublisher(String publisherName);
    public int modifyPublisher(String publisherName, String newName);
}