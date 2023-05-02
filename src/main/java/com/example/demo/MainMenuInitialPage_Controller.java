package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuInitialPage_Controller {

    @FXML
    private Button NewGameButton;

    @FXML
    private Button HighScoreButton;

    @FXML
    private void handleNewGameButtonClick(){
        /*
        This method is called whenever the player clicks on the New Game Button.
        This code will clear the screen and then launch the New Game Select Page
         */

        // Clears the stage
        Stage currentStage = (Stage) NewGameButton.getScene().getWindow();
        currentStage.close();
        System.out.println("WhiteRectangle: Stage Closed, open New Game Select Stage");

        // Runs the New Game Menu
        try {
            Parent newGamePage = FXMLLoader.load(getClass().getResource("/com/example/demo/MainMenuNewGamePage.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(newGamePage));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleHighScoreButtonClick() {
        /*
        Not yet implemented, but will be a high score panel based on each game. This one will be a lot of work. Ugh.
         */
        // Clears the stage
        Stage stage = (Stage) HighScoreButton.getScene().getWindow();
        stage.close();

        try {
            Parent newGamePage = FXMLLoader.load(getClass().getResource("/com/example/demo/HighScoresPage.fxml"));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newGamePage));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
