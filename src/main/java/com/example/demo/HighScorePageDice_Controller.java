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
import java.util.Objects;
import java.util.ResourceBundle;

public class HighScorePageDice_Controller extends WhiteRectangleMain implements Initializable {

    @FXML
    private TableView<Dice_High_Score> diceTable = new TableView<>();

    @FXML
    private TableColumn<Dice_High_Score, String> dateColumn = new  TableColumn<>();

    @FXML
    private TableColumn<Dice_High_Score, Double> acctColumn= new TableColumn<>();

    @FXML
    private Button mainMenuButton;

    @FXML
    private Button highScoreButton;

    @FXML
    private void handleMainMenuButtonClick() {
        Stage currentStage = (Stage) mainMenuButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/MainMenuInitialPage.fxml")));
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
            Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/HighScoresPage.fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(mainMenuPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ObservableList<Dice_High_Score> highscores = FXCollections.observableArrayList();

    @FXML
    void setHighscoresTable() {

        // This should work. Not sure why not. can confirm thanks to breakpoints that data is passed. Just table never visually updates.
        highscores.clear();
        try (Connection connection = DriverManager.getConnection(WhiteRectangleMain.DATABASE_NAME)) {
            String select = "SELECT * FROM dice_game_highscores ORDER BY score DESC LIMIT 5";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                double score = resultSet.getDouble("score");
                highscores.add(new Dice_High_Score(date, score));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // ooh, this is neater!
        Platform.runLater(() -> diceTable.setItems(highscores));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        acctColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        acctColumn.setCellFactory(tc -> new TableCell<>() {
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

