package main.java.сontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.java.Bananaplayer;
import main.java.Constants;

public class CongratulationsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button closeButton;

    @FXML
    void initialize() {
        closeButton.setOnAction(actionEvent -> {
            closeButton.getScene().getWindow().hide();
        });
    }
}