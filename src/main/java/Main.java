package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException, JavaLayerException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Hi! Let's go!");
        stage.show();

        new Bananaplayer(Constants.SOUND_HELLO).playSound();
    }

    public static void main(String[] args) {
        launch();
        }
}
