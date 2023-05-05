package com.example.demo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HighScorePageDice_Controller extends WhiteRectangleMain implements Initializable {

    @FXML
    private TableView<DHighscore> diceTable = new TableView<>();

    @FXML
    private TableColumn<DHighscore, String> dateColumn = new  TableColumn<>();

    @FXML
    private TableColumn<DHighscore, Double> acctColumn= new TableColumn<>();

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button highScoreButton;

    @FXML
    private void handleMainMenuButtonClick() {
        Stage currentStage = (Stage) mainMenuButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent mainMenuPage = FXMLLoader.load(getClass().getResource("/com/example/demo/MainMenuInitialPage.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(mainMenuPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleHighScoreButtonClick() {
        Stage currentStage = (Stage) highScoreButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent mainMenuPage = FXMLLoader.load(getClass().getResource("/com/example/demo/HighScoresPage.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(mainMenuPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ObservableList<DHighscore> highscores = FXCollections.observableArrayList();

    @FXML
    void setHighscoresTable() {

        // This should work. Not sure why not. can confirm thanks to breakpoitns that data is passed. Just table never visually updates.
        highscores.clear();
        try (Connection connection = DriverManager.getConnection(WhiteRectangleMain.DATABASE_NAME)) {
            String select = "SELECT * FROM dice_game_highscores ORDER BY score DESC LIMIT 5";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                double score = resultSet.getDouble("score");
                highscores.add(new DHighscore(date, score));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Platform.runLater(() -> {
            diceTable.setItems(highscores);
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        acctColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        acctColumn.setCellFactory(tc -> new TableCell<DHighscore, Double>() {
            @Override
            protected void updateItem(Double score, boolean empty) {
                super.updateItem(score, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(String.format("%.2f", score));
                }
            }
        });
        setHighscoresTable();
    }
}

