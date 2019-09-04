/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Pocsai Zsolt
 */
public class Dialog extends Stage {
    protected FXMLLoader fxmlLoader;
    
    public Dialog(String fxmlPath) {
        Pane root = new Pane();
        Scene scene;
        this.fxmlLoader = new FXMLLoader();
        
        try {
            root = fxmlLoader.load(getClass().getResource(fxmlPath).openStream());
        } catch (IOException e) {
            System.err.println("Error: at loading dialog " + fxmlPath);
            System.err.println(e);
        }
        
        scene = new Scene(root);
        setScene(scene);
        
        connectToGUIController();
    }
    
    public Dialog(String fxmlPath, String title) {
        this(fxmlPath);
        setTitle(title);
    }
    
    public FXMLLoader getFXMLLoader() {
        return fxmlLoader;
    }
    
    private void connectToGUIController() {
        GUIController controller = fxmlLoader.getController();
        if (controller != null) controller.setDialog(this);
    }
}
