package bookstore.model;

import bookstore.model.Category;
import java.util.ArrayList;

public interface CategoryDAO {
    
    public ArrayList<Category> getAllCategories();
    public int addCategory(Category category);
    public int modifyCategory(String categoryName, Category newCategory);
    public int deleteCategory(String categoryName);
    
    public int getNumberOfBooksInCategory(String categoryName);
    public ArrayList<Category> getCategoriesWithBookCount();
}