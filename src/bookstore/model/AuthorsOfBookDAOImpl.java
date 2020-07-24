package bookstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorsOfBookDAOImpl implements AuthorsOfBookDAO {
    private final Connection dbConn;
    
    public AuthorsOfBookDAOImpl(Connection conn) {
        this.dbConn = conn;
    }
    
    @Override
    public AuthorsOfBook getAuthorsOfBook(long isbn) {
        AuthorsOfBook authorsOfBook = new AuthorsOfBook(isbn);
        Statement stm;
        String sql;
        ResultSet rs;
        
        sql = "SELECT * FROM szerzoje WHERE isbn='" + isbn + "'";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                authorsOfBook.getAuthors().add(rs.getString("szerzo"));
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println("function: getAuthorsOfBook");
            System.err.println(e);
        }
        return authorsOfBook;
    }
    
    @Override
    public int addAuthorsOfBook(AuthorsOfBook authorsOfBook) {
        Statement stm;
        String sql;
        int result = -1;
        
        for (int i = 0; i < authorsOfBook.getAuthors().size(); i++) {
            
            sql = "INSERT INTO szerzoje VALUES (" +
                  "'" + authorsOfBook.getIsbn() + "', " +
                  "'" + authorsOfBook.getAuthors().get(i) + "')";
            
            try {
                stm = dbConn.createStatement();
                result = stm.executeUpdate(sql);
                stm.close();
            } catch (SQLException e) {
                System.err.println("function: addAuthorsOfBook");
                System.err.println(e);
            }
        }
        
        return result;
    }
    
    @Override
    public int modifyAuthorsOfBook(AuthorsOfBook newAOB) {
        int result = -1;
        
        result = deleteAuthorsOfBook(newAOB.getIsbn());
        
        if (result == -1) return result;
        
        result = addAuthorsOfBook(newAOB);
        
        return result;
    }
    
    @Override
    public int deleteAuthorsOfBook(long isbn) {
        Statement stm;
        String sql;
        int result = -1;
        
        sql = "DELETE FROM szerzoje WHERE isbn='" + isbn + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println("function: deleteAuthorsOfBook");
            System.err.println(e);
        }
        
        return result;
    }
}
