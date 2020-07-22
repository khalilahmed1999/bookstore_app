package bookstore.model;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAOImpl implements BookDAO {
    Connection dbConn;

    public BookDAOImpl(Connection conn) {
        dbConn = conn;
    }
    
    @Override
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        Book tempBook;
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM konyv";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                tempBook = new Book(
                        rs.getLong("isbn"),
                        rs.getString("cim"),
                        rs.getString("kiado"),
                        rs.getInt("kiadasi_ev"),
                        rs.getString("kategoria"),
                        rs.getInt("oldalak_szama"),
                        rs.getInt("ar")
                );

                tempBook.setDateOfRegistration(rs.getDate("felvetel_datuma"));

                books.add(tempBook);
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }

        return books;
    }
    
    @Override
    public ArrayList<Book> getBooksOfCategory(String categoryName) {
        ArrayList<Book> books = new ArrayList<>();
        Book tempBook;
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM konyv WHERE kategoria='" + categoryName + "'";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                tempBook = new Book(
                        rs.getLong("isbn"),
                        rs.getString("cim"),
                        rs.getString("kiado"),
                        rs.getInt("kiadasi_ev"),
                        rs.getString("kategoria"),
                        rs.getInt("oldalak_szama"),
                        rs.getInt("ar")
                );

                tempBook.setDateOfRegistration(rs.getDate("felvetel_datuma"));

                books.add(tempBook);
            }
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return books;
    }
    
    @Override
    public Book getBookByISBN(long isbn) {
        Book book = null;
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM konyv WHERE isbn='" + isbn + "'";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                book = new Book(
                        rs.getLong("isbn"),
                        rs.getString("cim"),
                        rs.getString("kiado"),
                        rs.getInt("kiadasi_ev"),
                        rs.getString("kategoria"),
                        rs.getInt("oldalak_szama"),
                        rs.getInt("ar")
                );

                book.setDateOfRegistration(rs.getDate("felvetel_datuma"));
            }
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return book;
    }

    @Override
    public int addBook(Book book) {
        String sql;
        Statement stm;
        int result = 0;

        sql = "INSERT INTO konyv VALUES " +
        "('" + book.getIsbn() + "', '" + 
               book.getTitle() + "', '" + 
               book.getPublisher() + "', '" +
               book.getYearOfPublish() + "', '" +
               book.getCategory() + "', '" +
               book.getNumberOfPages() + "', '" + 
               book.getPrice() + "', " + 
               "SYSDATE)";

        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println("Error at: addBook()");
            System.err.println("sql: " + sql);
            System.err.println(e);
        }

        return result;
    }
    
    @Override
    public int deleteBook(long isbn) {
        Statement stm;
        String sql;
        int result = -1;
        
        sql = "DELETE FROM konyv WHERE isbn='" + String.valueOf(isbn) + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int modifyBook(long isbn, Book newBook) {
        Statement stm;
        String sql;
        int result = -1;
        
        sql = 
        "UPDATE konyv " +
        "SET " +
        "cim='" + newBook.getTitle() + "', " +
        "kiado='" + newBook.getPublisher() + "', " +
        "kiadasi_ev='" + String.valueOf(newBook.getYearOfPublish()) + "', " +
        "kategoria='" + newBook.getCategory() + "', " +
        "oldalak_szama='" + String.valueOf(newBook.getNumberOfPages()) + "', " +
        "ar='" + String.valueOf(newBook.getPrice()) + "' " +
        "WHERE isbn='" + String.valueOf(isbn) + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println("function: modifyBook");
            System.err.println("sql: " + sql);
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public ArrayList<Book> getBooksBySearch(String keyword) {
        ArrayList<Book> books = new ArrayList<>();
        Statement stm;
        String sql;
        ResultSet rs;
        
        sql = "SELECT konyv.isbn, cim, szerzo FROM konyv LEFT JOIN szerzoje " +
                "ON konyv.isbn = szerzoje.isbn " +
                "WHERE cim LIKE '%" + keyword + "%' OR szerzo LIKE '%" + keyword + "%'";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                books.add(getBookByISBN(rs.getLong("isbn")));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return books;
    }
    
    @Override
    public ArrayList<Book> getBooksByPopularity(String category) {
        ArrayList<Book> books = new ArrayList<>();
        Statement stm;
        String sql;
        ResultSet rs;
        
        if (category.equals("")){
            sql = "SELECT tbl.t_isbn AS k_isbn, tbl.eladott FROM " + 
                    "(SELECT konyv.isbn AS t_isbn, SUM(mennyiseg) AS eladott " +
                    "FROM konyv, rendeles_tetel " +
                    "WHERE konyv.isbn = rendeles_tetel.isbn " +
                    "GROUP BY konyv.isbn ORDER BY eladott DESC) tbl " +
                    "WHERE ROWNUM <= 5";
        } else {
            sql = "SELECT tbl.t_isbn AS k_isbn, tbl.eladott FROM " + 
                    "(SELECT konyv.isbn AS t_isbn, SUM(mennyiseg) AS eladott " +
                    "FROM konyv, rendeles_tetel " +
                    "WHERE konyv.isbn = rendeles_tetel.isbn " +
                    "AND konyv.kategoria = '" + category + "' " +
                    "GROUP BY konyv.isbn ORDER BY eladott DESC) tbl " +
                    "WHERE ROWNUM <= 5";
        }
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                books.add(getBookByISBN(rs.getLong("k_isbn")));
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(sql);
            System.err.println(e);
        }
        return books;
    }
    
    @Override
    public ArrayList<Book> getNewestBooks() {
        ArrayList<Book> books = new ArrayList<>();
        Statement stm;
        String sql;
        ResultSet rs;
        
        sql = "SELECT tbl.isbn AS t_isbn FROM " +
                "(SELECT isbn FROM konyv ORDER BY felvetel_datuma DESC) tbl " +
                "WHERE ROWNUM <= 10";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                books.add(getBookByISBN(rs.getLong("t_isbn")));
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return books;
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<String> getAllWriters() {
        ArrayList<String> writers = new ArrayList<>();
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM iro";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                writers.add(rs.getString("nev"));
            }
        } catch (SQLException e) {
            System.err.println(e);
        }

        return writers;
    }
    
    @Override
    public int addWriter(String writerName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "INSERT INTO iro VALUES " +
              "('" + writerName + "')";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int deleteWriter(String writerName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "DELETE FROM iro WHERE nev='" + writerName + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int modifyWriter(String writerName, String newName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "UPDATE iro SET nev = '" + newName + "' " + 
              "WHERE nev='" + writerName + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<Publisher> getAllPublishersAsObject() {
        ArrayList<Publisher> publishers = new ArrayList<>();
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM kiado";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                publishers.add(new Publisher(rs.getString("nev")));
            }
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return publishers;
    }
    
    @Override
    public ArrayList<String> getAllPublishers() {
        ArrayList<String> publishers = new ArrayList<>();
        String sql;
        Statement stm;
        ResultSet rs;

        sql = "SELECT * FROM kiado";

        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                publishers.add(rs.getString("nev"));
            }
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return publishers;
    }
    
    @Override
    public int addPublisher(String publisherName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "INSERT INTO kiado VALUES " +
              "('" + publisherName + "')";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int deletePublisher(String publisherName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "DELETE FROM kiado WHERE nev='" + publisherName + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int modifyPublisher(String publisherName, String newName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "UPDATE kiado SET nev = '" + newName + "' " + 
              "WHERE nev='" + publisherName + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
}