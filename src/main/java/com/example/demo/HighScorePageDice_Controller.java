package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HighScorePageDice_Controller {
    // TODO -- Make Table go brrr
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
}

