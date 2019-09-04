package bookstore.view;

import bookstore.controller.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

public class Main extends Application {
    private BookStoreController controller = BookStoreControllerImpl.getInstance();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        if (controller.startConnection() < 0) return;
        Scene scene;
        Pane root = null;
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            root = fxmlLoader.load(getClass().getResource("fxml/MainGUI.fxml").openStream());
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
        scene = new Scene(root, 850, 600);
        stage.setTitle("BookstoreApp");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        controller.killConnection();
        System.out.println("BookstoreApp closed.");
    }
}