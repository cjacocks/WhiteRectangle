package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuInitialPage_Controller {

    @FXML
    private Button NewGameButton;

    @FXML
    private Button LoadGameButton;

    @FXML
    private Button HighScoreButton;

    @FXML
    private void handleNewGameButtonClick() {
        Stage stage = (Stage) NewGameButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleLoadGameButtonClick() {
        Stage stage = (Stage) LoadGameButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleHighScoreButtonClick() {
        Stage stage = (Stage) HighScoreButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

}
