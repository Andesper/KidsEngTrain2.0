package main.java.сontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.java.Bananaplayer;
import main.java.Constants;
import main.java.Main;
import main.java.Question;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class TestController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button answButtonFirst;

    @FXML
    private Button answButtonFourth;

    @FXML
    private Button answButtonSecond;

    @FXML
    private Button answButtonThird;

    @FXML
    private Label engWordLabel;

    @FXML
    private Label correctAnswerCountLabel;
    private int correctAnswerCount;

    @FXML
    void initialize() throws SQLException {
            Question question = new Question();
            ArrayList<String> sceneText = new ArrayList<>();

            printQuestion(question, sceneText);

            answButtonFirst.setOnAction(actionEvent -> {
                answerVerification(sceneText.get(0), question.getCorrectAnswer());
                try {
                    printQuestion(question, sceneText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            answButtonSecond.setOnAction(actionEvent -> {
                answerVerification(sceneText.get(1), question.getCorrectAnswer());
                try {
                    printQuestion(question, sceneText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            answButtonThird.setOnAction(actionEvent -> {
                answerVerification(sceneText.get(2), question.getCorrectAnswer());
                try {
                    printQuestion(question, sceneText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });

            answButtonFourth.setOnAction(actionEvent -> {
                answerVerification(sceneText.get(3), question.getCorrectAnswer());
                try {
                    printQuestion(question, sceneText);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    private void printQuestion(Question question, ArrayList sceneText) throws SQLException {
        if(correctAnswerCount < 3) {
            question.getQuestions();
            sceneText.clear();
            sceneText.add(question.getCorrectAnswer());
            sceneText.add(question.getFirstAnswer());
            sceneText.add(question.getSecondAnswer());
            sceneText.add(question.getThirdAnswer());
            Collections.shuffle(sceneText);

            correctAnswerCountLabel.setText(String.valueOf(correctAnswerCount));
            engWordLabel.setText(question.getQuestion());
            answButtonFirst.setText((String) sceneText.get(0));
            answButtonSecond.setText((String) sceneText.get(1));
            answButtonThird.setText((String) sceneText.get(2));
            answButtonFourth.setText((String) sceneText.get(3));
        }
        else {
            correctAnswerCountLabel.getScene().getWindow().hide();

            //new Bananaplayer(Constants.SOUND_YES).playSound();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/congratulations.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 700, 700);
                Stage stage = new Stage();
                stage.setTitle("Congratulations!!!");
                stage.setScene(scene);
                //stage.setResizable(false);
                stage.showAndWait();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void answerVerification(String userAnswer, String correctAnswer) {
        if(userAnswer.equals(correctAnswer)) {
            correctAnswerCount++;
            new Bananaplayer(Constants.SOUND_YES).playSound();
        }
        else {
            new Bananaplayer(Constants.SOUND_NO).playSound();
        }
    }
}

