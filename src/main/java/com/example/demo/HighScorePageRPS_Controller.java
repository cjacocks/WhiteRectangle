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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HighScorePageRPS_Controller extends WhiteRectangleMain implements Initializable {

    @FXML
    private TableView<RHighScore> hsTable = new TableView<>();

    @FXML
    private TableColumn<RHighScore, String> dateColumn = new TableColumn<>();
    @FXML
    private TableColumn<RHighScore, Integer> turnColumn = new TableColumn<>();
    @FXML
    private TableColumn<RHighScore, Integer> playerColumn = new TableColumn<>();
    @FXML
    private TableColumn<RHighScore, Integer> adversaryColumn = new TableColumn<>();
    @FXML
    private Button mainMenuButton;

    @FXML
    private Button highScoreButton;

    ObservableList<RHighScore> highScores = FXCollections.observableArrayList();

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

    @FXML
    void setHsTable() {
        highScores.clear();
        try (Connection connection = DriverManager.getConnection(WhiteRectangleMain.DATABASE_NAME)){
            String select = "SELECT * FROM rps_game ORDER BY turns DESC, player DESC LIMIT 5";
            PreparedStatement preparedStatement = connection.prepareStatement(select);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                int turn = resultSet.getInt("turns");
                int player = resultSet.getInt("player");
                int adv = resultSet.getInt("adversary");

                if (WhiteRectangleMain.debugRPS) {
                    System.out.println("Dbug: date: " + date + " turn: " + turn + " player: " + player + " adv: " + adv);
                }

                highScores.add(new RHighScore(date, turn, player, adv));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        Platform.runLater(() -> {
            hsTable.setItems(highScores);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        turnColumn.setCellValueFactory(new PropertyValueFactory<>("turnCount"));
        playerColumn.setCellValueFactory(new PropertyValueFactory<>("playerScore"));
        adversaryColumn.setCellValueFactory(new PropertyValueFactory<>("adversaryScore"));
        setHsTable();
    }
}
