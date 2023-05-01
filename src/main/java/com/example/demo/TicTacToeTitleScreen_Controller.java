package com.example.demo;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToeTitleScreen_Controller {

    @FXML
    private Button ExitButton;

    @FXML
    private Button StartButton;

    @FXML
    private Text TitleText;

    @FXML
    private void startGame(ActionEvent event) throws IOException {
        // Load the game scene FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GameScreen.fxml"));
        Parent gameSceneRoot = loader.load();

        // Create the game scene
        Scene gameScene = new Scene(gameSceneRoot);

        // Get the current stage from the StartButton
        Stage stage = (Stage) StartButton.getScene().getWindow();

        // Set the new scene on the current stage
        stage.setScene(gameScene);

        // Show the updated stage
        stage.show();
    }

}
