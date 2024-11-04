package org.example.examenfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage ventana;

    @Override
    public void start(Stage stage) throws IOException {
        HelloApplication.ventana = stage;
        loadFXML("hello-view.fxml","Hola mundo");
        stage.show();
    }

    public static void loadFXML(String view, String title) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(view));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),800,600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ventana.setTitle(title);
        ventana.setScene(scene);
        ventana.setResizable(false);
    }

    public static void main(String[] args) {
        launch();
    }
}