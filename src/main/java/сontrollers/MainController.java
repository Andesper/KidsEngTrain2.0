package main.java.сontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button newWordsButton;

    @FXML
    private Button startTestButton;

    @FXML
    void initialize() {
        newWordsButton.setOnAction(actionEvent -> {
            newWordsButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/addwords.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Add new words...");
                stage.setResizable(false);
                stage.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        startTestButton.setOnAction(actionEvent -> {
            startTestButton.getScene().getWindow().hide();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/test.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 700, 700);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Let's go!!!");
                stage.setResizable(false);
                stage.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
