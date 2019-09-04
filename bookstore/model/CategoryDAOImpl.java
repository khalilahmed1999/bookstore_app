package bookstore.model;

import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class CategoryDAOImpl implements CategoryDAO {
    private Connection dbConn;

    public CategoryDAOImpl(Connection conn) {
        dbConn = conn;
    }

    @Override
    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Category tempCategory = null;
        Statement stm;
        String sql;
        String parent;
        ResultSet resultSet;
        Boolean newCategory;

        sql = "SELECT * FROM kategoria";

        try {
            stm = dbConn.createStatement();
            resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                
                newCategory = true;
                for (Category c : categories) {
                    if (c.getName().equals(resultSet.getString("megnevezes"))) {
                        newCategory = false;
                        tempCategory = c;
                        break;
                    }
                }
                
                if (newCategory) tempCategory = new Category(
                                resultSet.getString("megnevezes"));
                
                parent = resultSet.getString("fokategoria");
                
                if (parent != null) {
                    for (Category c : categories) {
                        if (c.getName().equals(parent) && tempCategory != null) {
                            tempCategory.setParent(c);
                            break;
                        }
                    }
                    if (tempCategory.getParent() == null) {
                        tempCategory.setParent(new Category(parent));
                        categories.add(tempCategory.getParent());
                    }
                }
                if (newCategory) categories.add(tempCategory);
            }
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return categories;
    }
    
    @Override
    public int addCategory(Category newCategory) {
        Statement stm = null;
        String name = newCategory.getName();
        String parent;
        String sql;
        int result = 0;

        if (newCategory.getParent() != null) {
            parent = newCategory.getParent().getName();
            sql = "INSERT INTO kategoria VALUES ('" + name + "', '" + parent + "')";
        } else {
            sql = "INSERT INTO kategoria (megnevezes) VALUES ('" + name + "')";
        }

        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return result;
    }
    
    @Override
    public int deleteCategory(String categoryName) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "DELETE FROM kategoria WHERE megnevezes='" + categoryName + "'";
        
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
    public int modifyCategory(String categoryName, Category newCategory) {
        Statement stm;
        String sql;
        int result = 0;
        
        if (newCategory.getParent() == null) {
            sql = "UPDATE kategoria SET " +
                  "megnevezes='" + newCategory.getName() + "', " +
                  "fokategoria=NULL " +
                  "WHERE megnevezes='" + categoryName + "'";
        } else {
            sql = "UPDATE kategoria SET " +
                  "megnevezes='" + newCategory.getName() + "', " +
                  "fokategoria='" + newCategory.getParent().getName() + "' " +
                  "WHERE megnevezes='" + categoryName + "'";
        }
        
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
    public int getNumberOfBooksInCategory(String categoryName) {
        Statement stm;
        ResultSet rs;
        String sql;
        int numberOfBooks = 0;
        
        sql = "SELECT COUNT(isbn) AS sum FROM konyv, kategoria " +
                "WHERE kategoria.megnevezes = '" + categoryName + "' " +
                "AND konyv.kategoria = kategoria.megnevezes";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            rs.next();
            numberOfBooks = rs.getInt("sum");
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return numberOfBooks;
    }
    
    @Override
    public ArrayList<Category> getCategoriesWithBookCount() {
        ArrayList<Category> categories = new ArrayList<>();
        Category tempCategory;
        Statement stm;
        ResultSet rs;
        String sql;
        
        sql = "SELECT megnevezes, fokategoria, COUNT(isbn) AS books " +
                "FROM kategoria " +
                "LEFT JOIN konyv ON megnevezes = konyv.kategoria " +
                "GROUP BY megnevezes, fokategoria";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                tempCategory = new Category(rs.getString("megnevezes"));
                if (rs.getString("fokategoria") != null) {
                    tempCategory.setParent(new Category(rs.getString("fokategoria")));
                }
                
                tempCategory.setNumberOfBooks(rs.getInt("books"));
                
                categories.add(tempCategory);
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        return categories;
    }
}