package org.example;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        URL fxmlUrl = getClass().getClassLoader().getResource("users.fxml");
        HBox root = FXMLLoader.<HBox>load(fxmlUrl);

        Scene scene = new Scene(root);

        scene.getStylesheets().add("style.css");
        stage.setScene(scene);

        stage.show();
    }

}