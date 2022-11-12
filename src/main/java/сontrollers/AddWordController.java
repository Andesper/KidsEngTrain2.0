package main.java.сontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import main.java.Main;
import main.java.Word;
import main.java.DatabaseHandler;

public class AddWordController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField addEngWordField;

    @FXML
    private Button addNewWordButton;

    @FXML
    private TextField addRusWordField;

    @FXML
    void initialize() {
        addNewWordButton.setOnAction(actionEvent -> {
            addNewWord();
        });
    }

    private void addNewWord() {
        String engWord = addEngWordField.getText().trim();
        String rusWord = addRusWordField.getText().trim();
        String streamWord = "unknown";
        Word word = new Word(engWord, rusWord, streamWord);

        new DatabaseHandler().addWords(word);

        addEngWordField.clear();
        addRusWordField.clear();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/main/resources/fxml/successful.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            Stage stage = new Stage();
            stage.setTitle("Successful");
            stage.setScene(scene);
            stage.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

