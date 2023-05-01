package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuNewGamePage_Controller {

    @FXML
    private Button connectFourButton;

    @FXML
    private Button ticTacToeButton;

    @FXML
    private Button rockPaperScissorsButton;

    // TODO Decide if adding a new game and rename this button constructor and assign fxid and event name.
    @FXML
    private Button diceGameButton;

    @FXML
    private Button goBackButton;

    @FXML
    private void handleConnectFourButtonClick() {
        Stage stage = (Stage) connectFourButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleTicTacToeButtonClick() {
        Stage stage = (Stage) ticTacToeButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleRockPaperScissorsButtonClick() {
        Stage stage = (Stage) rockPaperScissorsButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleDiceGameButtonClick () {
        Stage stage = (Stage) diceGameButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

    @FXML
    private void handleGoBackButtonClick() {
        Stage stage = (Stage) goBackButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }
}
