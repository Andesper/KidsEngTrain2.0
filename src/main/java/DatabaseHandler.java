package main.java;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHandler extends SQLConfig {
    Connection dbConnection;

    public Connection getDbConnection () throws ClassNotFoundException, SQLException {
        String connectionRequest = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionRequest, dbUser, dbPass);

        return dbConnection;
    }

    public void addWords (Word word) {
        String sqlInsert = "INSERT INTO " + Constants.USER_TABLE
                + "("
                + Constants.WORD_EN
                + ","
                + Constants.WORD_RU
                + ","
                + Constants.WORD_STREAM
                + ")"
                + "VALUES(?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(sqlInsert);
            preparedStatement.setString(1, word.getEngWord());
            preparedStatement.setString(2, word.getRusWord());
            preparedStatement.setString(3, word.getStreamWord());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getWord(Word word) {
        ResultSet result = null;

        String sqlSelect = "SELECT * FROM " + Constants.USER_TABLE + " WHERE " +
                Constants.WORD_EN + "=?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(sqlSelect);
            preparedStatement.setString(1, word.getEngWord());
            result = preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public ArrayList getALLWords() throws SQLException {
        ArrayList<String[]> wordsList = new ArrayList<>();
        String[] wordAttributes = new String[3];
        ResultSet sqlBuffer = null;

        String sqlSelect = "SELECT * FROM " + Constants.USER_TABLE;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(sqlSelect);
            sqlBuffer = preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        while (sqlBuffer.next()) {
            wordAttributes[0] = sqlBuffer.getString(2);
            wordAttributes[1] = sqlBuffer.getString(3);
            wordAttributes[2] = sqlBuffer.getString(4);
            wordsList.add(wordAttributes);
        }
        return wordsList;
    }
    public ArrayList getRandomWord() throws SQLException {
        ResultSet sqlBuffer = null;
        ArrayList<Word> randomWords = new ArrayList<>();

        String sqlSelect = "SELECT * FROM " + Constants.USER_TABLE + " ORDER BY RAND() LIMIT 4";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getDbConnection().prepareStatement(sqlSelect);
            sqlBuffer = preparedStatement.executeQuery();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        while (sqlBuffer.next()) {
            randomWords.add(new Word(sqlBuffer.getString(2), sqlBuffer.getString(3), sqlBuffer.getString(4)));
        }
        return randomWords;
    }
}
