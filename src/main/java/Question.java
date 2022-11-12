package main.java;

import java.sql.SQLException;
import java.util.ArrayList;

public class Question {
    private String question;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String correctAnswer;


    public Question(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String correctAnswer) {
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.correctAnswer = correctAnswer;
    }

    public Question() {

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void getQuestions() throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ArrayList<Word> wordsList = dbHandler.getRandomWord();

        //double randomCount = Math.random() * 100;
/*
        this.setQuestion(wordsList.get(0).getEngWord());
        this.setCorrectAnswer(wordsList.get(0).getRusWord());
        this.setFirstAnswer(wordsList.get(1).getRusWord());
        this.setSecondAnswer(wordsList.get(2).getRusWord());
        this.setThirdAnswer(wordsList.get(3).getRusWord());
*/
        this.setQuestion(wordsList.get(0).getRusWord());
        this.setCorrectAnswer(wordsList.get(0).getEngWord());
        this.setFirstAnswer(wordsList.get(1).getEngWord());
        this.setSecondAnswer(wordsList.get(2).getEngWord());
        this.setThirdAnswer(wordsList.get(3).getEngWord());
    }
}
