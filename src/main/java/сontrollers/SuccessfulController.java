package main.java.сontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SuccessfulController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button successfulButton;

    @FXML
    void initialize() {
        successfulButton.setOnAction(event -> {
            successfulButton.getScene().getWindow().hide();
        });
    }

}
