package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuNewGamePage_Controller {

    @FXML
    private Button connectFourButton;

    @FXML
    private Button ticTacToeButton;

    @FXML
    private Button rockPaperScissorsButton;

    @FXML
    private Button diceGameButton;

    @FXML
    private Button goBackButton;

    @FXML
    private Button memoryGameButton;


    @FXML
    private void handleConnectFourButtonClick() {
        Stage currentStage = (Stage) connectFourButton.getScene().getWindow();
        currentStage.close();

        Platform.runLater(() -> {
            new Connect4Game().start(new Stage());
        });
    }

    @FXML
    private void handleTicTacToeButtonClick() {
        Stage currentStage = (Stage) ticTacToeButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent newGamePage = FXMLLoader.load(getClass().getResource("/com/example/demo/TicTacToe_GameScreen.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newGamePage));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRockPaperScissorsButtonClick() {
        /*
        This method runs when the user clicks on the button to play a refreshing round of rock paper scissors.
        Clears the stage then runs the Rock Paper Scissors Game
         */
        Stage currentStage = (Stage) rockPaperScissorsButton.getScene().getWindow();
        currentStage.close();

        /*
        Cleared out a metric ass ton of debug statements here.
        Apparently breakpoints are a thing.
        I'm pissed I didn't know about them sooner, I wouldn't have had to add all the debug shit.
        But my code works for now. Yay.

        -- Chris
         */
        try {
            Parent newGamePage = FXMLLoader.load(getClass().getResource("/com/example/demo/RockPaperScissorsGame.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newGamePage));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDiceGameButtonClick () {
        Stage currentStage = (Stage) diceGameButton.getScene().getWindow();
        currentStage.close();

        Platform.runLater(() -> {
            new CHDice().start(new Stage());
        });
    }

    @FXML
    private void handleGoBackButtonClick() {
        /*
        When triggered, takes the user make to the main menu. Not that there is much there. If only we had time to sort
        out fucking save game states. Oh well.
         */
        Stage currentStage = (Stage) goBackButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent newGamePage = FXMLLoader.load(getClass().getResource("/com/example/demo/MainMenuInitialPage.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newGamePage));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleMemoryGameButtonClick() {
        Stage currentStage = (Stage) memoryGameButton.getScene().getWindow();
        currentStage.close();

        Platform.runLater(() -> {
            new MemoryGame().start(new Stage());
        });
    }
}
