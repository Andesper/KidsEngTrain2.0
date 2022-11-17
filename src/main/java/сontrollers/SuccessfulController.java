package main.java.сontrollers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
            Stage closableStage = (Stage) successfulButton.getScene().getWindow();
            closableStage.close();
        });
    }

}
