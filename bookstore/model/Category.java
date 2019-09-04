package bookstore.model;

import java.util.ArrayList;

public class Category {
    private String name;
    private Category parent = null;
    private ArrayList<Category> subcategories = new ArrayList<Category>();
    private int numberOfBooks = 0;

    public Category(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Category getParent() {
        return parent;
    }
    public ArrayList<Category> getSubcategories() {
        return subcategories;
    }
    public void setName(String newName) {
        name = newName;
    }
    public void setParent(Category newParent) {
        if (newParent != null) {
            parent = newParent;
            parent.getSubcategories().add(this);
        }
    }
    public boolean addSubcategory(Category subcategory) {
        if (subcategories.contains(subcategory)) {
            return false;
        } else {
            subcategories.add(subcategory);
            subcategory.setParent(this);
            return true;
        }
    }
    public int getNumberOfBooks() {
        return numberOfBooks;
    }
    public void setNumberOfBooks(int number) {
        numberOfBooks = number;
    }
}