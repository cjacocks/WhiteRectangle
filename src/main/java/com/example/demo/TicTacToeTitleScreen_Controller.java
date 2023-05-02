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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/TicTacToe_GameScreen.fxml"));
        Parent gameSceneRoot = loader.load();
        Scene gameScene = new Scene(gameSceneRoot);
        Stage stage = (Stage) StartButton.getScene().getWindow();
        stage.setScene(gameScene);
        stage.show();
    }

}
