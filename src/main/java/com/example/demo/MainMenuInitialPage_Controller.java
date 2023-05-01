package com.example.demo;

import javafx.event.ActionEvent;
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
    private void handleNewGameButtonClick(ActionEvent event){
        Stage currentStage = (Stage) NewGameButton.getScene().getWindow();
        currentStage.close();
        System.out.println("WhiteRectangle: Stage Closed");

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
        Stage stage = (Stage) HighScoreButton.getScene().getWindow();
        stage.close();
        // TODO handle the rest of this event
    }

}
