package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import main.java.Constants;

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
