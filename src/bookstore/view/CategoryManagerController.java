/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import bookstore.model.Category;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author Pocsai Zsolt
 */
public class CategoryManagerController extends GUIController {
    @FXML private TableView<Category> tblCategories;
    
    public CategoryManagerController() {}
    
    @FXML
    private void initialize() {
        createTable();
        update();
    }
    
    private void update() {
        tblCategories.getItems().clear();
        for (Category c : controller.getCategoriesWithBookCount()) {
            tblCategories.getItems().add(c);
        }
    }
    
    private void createTable() {
        TableColumn<Category, String> colName = new TableColumn<>();
        TableColumn<Category, String> colParent = new TableColumn<>();
        TableColumn<Category, Integer> colBookNum = new TableColumn<>();
        
        colName.setText("Category");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        colParent.setText("Parent Category");
        colParent.setCellValueFactory(
                new Callback<CellDataFeatures<Category, String>, 
                        ObservableValue<String>>() {
                    public ObservableValue<String> call(CellDataFeatures<Category, String> c) {
                        if (c.getValue().getParent() != null) {
                            return new ReadOnlyObjectWrapper(c.getValue().getParent().getName());
                        } else {
                            return new ReadOnlyObjectWrapper("");
                        }
                    }
                });
        
        colBookNum.setText("Number Of Books");
        colBookNum.setCellValueFactory(new PropertyValueFactory<>("numberOfBooks"));
        
        tblCategories.getColumns().addAll(colName, colParent, colBookNum);
    }
    
    @FXML
    private void clickAdd() {
        Dialog addCategory = new Dialog("fxml/AddCategoryGUI.fxml", "New Category");
        addCategory.showAndWait();
        update();
    }
    
    @FXML
    private void clickDelete() {
        if (tblCategories.getSelectionModel().isEmpty()) return;
        
        Category forDelete = tblCategories.getSelectionModel().getSelectedItem();
        if (forDelete.getNumberOfBooks() > 0) {
            new MessageDialog("Can't delete this category!");
            return;
        }
        
        controller.deleteCategory(forDelete.getName());
        update();
    }
    
    @FXML
    private void clickModify() {
        if (tblCategories.getSelectionModel().isEmpty()) return;
        
        Dialog modifyCategory = new Dialog("fxml/AddCategoryGUI.fxml", "Modify Category");
        AddCategoryController catController = modifyCategory.getFXMLLoader().getController();
        catController.setModify(tblCategories.getSelectionModel().getSelectedItem().getName());
        modifyCategory.showAndWait();
        
        update();
    }
}
