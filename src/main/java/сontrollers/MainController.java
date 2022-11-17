package main.java.сontrollers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
            Stage closableStage = (Stage) newWordsButton.getScene().getWindow();
            closableStage.close();

            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/main/resources/fxml/addwords.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Add new words...");
            stage.setResizable(false);
            stage.show();
        });

        startTestButton.setOnAction(actionEvent -> {
            Stage closableStage = (Stage) startTestButton.getScene().getWindow();
            closableStage.close();

            Stage stage = new Stage();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/main/resources/fxml/test.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Let's go!!!");
            stage.setResizable(false);
            stage.show();

        });
    }

}
