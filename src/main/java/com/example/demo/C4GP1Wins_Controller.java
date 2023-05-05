package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class C4GP1Wins_Controller {

    @FXML
    private Button mainMenuButton;

    @FXML
    private void handleMainMenuButtonClick() {
        Stage currentStage = (Stage) mainMenuButton.getScene().getWindow();
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
}
