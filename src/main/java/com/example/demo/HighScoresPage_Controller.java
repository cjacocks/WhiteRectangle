package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HighScoresPage_Controller {

    @FXML
    private Button BackToMainMenuButton;

    @FXML
    private Button rockPaperScissorsButton;

    @FXML
    private Button diceGameButton;

    @FXML
    private void handleBackToMainMenuButtonClick() {
        Stage currentStage = (Stage) BackToMainMenuButton.getScene().getWindow();
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
    private void handleRockPaperScissorsButton() {
        Stage currentStage = (Stage) rockPaperScissorsButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/HighScorePageRPS.fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(mainMenuPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDiceGameButton() {
        Stage currentStage = (Stage) diceGameButton.getScene().getWindow();
        currentStage.close();
        System.out.println("WhiteRectangle: run dice page");

        try {
            Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/HighScorePageDice.fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(mainMenuPage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
