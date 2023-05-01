package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class RPSGPlayerWin_Controller {

    @FXML
    private Button mainMenuButton;

    @FXML
    private void handleMainMenuButtonClick() {
        Stage currentStage = (Stage) mainMenuButton.getScene().getWindow();
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
}
