/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Category;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 *
 * @author Pocsai Zsolt
 */
public class AddCategoryController extends GUIController {
    @FXML private TextField txtNewCategory;
    @FXML private ComboBox<String> cmbParent;
    @FXML private Button btnModify;
    @FXML private Button btnAdd;
    private String oldCategory = null;
    
    public AddCategoryController() {
        
    }
    
    @FXML private void initialize() {
        for (Category category : controller.getAllCategories()) {
            cmbParent.getItems().add(category.getName());
        }
    }
    
    public void setModify(String oldCategory) {
        btnModify.setDisable(false);
        btnAdd.setDisable(true);
        txtNewCategory.setText(oldCategory);
        this.oldCategory = oldCategory;
    }
    
    @FXML
    private void clickAdd() {
        Category category;
        
        if (txtNewCategory.getText().equals("")) {
            new MessageDialog("Empty field!");
            return;
        }
        
        category = new Category(txtNewCategory.getText());
        
        if (cmbParent.getValue() != null) {
            category.setParent(new Category(cmbParent.getValue()));
        }
        
        if (controller.addCategory(category) > 0) {
            closeDialog();
        } else {
            new MessageDialog("Upload was not successfull!");
        }
    }
    
    @FXML
    private void clickCancel() {
        closeDialog();
    }
    
    @FXML
    private void clickModify() {
        Category category;
        
        if (txtNewCategory.getText().equals("")) {
            new MessageDialog("Empty category name!");
            return;
        }
        
        category = new Category(txtNewCategory.getText());
        
        if (cmbParent.getValue() != null) {
            category.setParent(new Category(cmbParent.getValue()));
        }
        
        if (controller.modifyCategory(oldCategory, category) > 0) {
            closeDialog();
        } else {
            new MessageDialog("Upload was not successfull!");
        }
    }
}
