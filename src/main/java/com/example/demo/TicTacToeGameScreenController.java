package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TicTacToeGameScreenController {

    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Button mainMenuButton;


    @FXML
    private Label TurnText;

    private boolean isX = true;

    @FXML
    private void buttonClicked(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();

        if (clickedButton.getText().isEmpty()) {
            clickedButton.setText(isX ? "X" : "O");
            isX = !isX;
            TurnText.setText(isX ? "X's Turn" : "O's Turn");
            checkForWinner();
        }
    }

    private void checkForWinner() {
        String[][] board = new String[][] {
            {Button1.getText(), Button2.getText(), Button3.getText()},
            {Button4.getText(), Button5.getText(), Button6.getText()},
            {Button7.getText(), Button8.getText(), Button9.getText()}
        };

        for (int i = 0; i < 3; i++) {
            // Check rows
            if (!board[i][0].isEmpty() && board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2])) {
                TurnText.setText(board[i][0] + " Wins!");
                return;
            }
            // Check columns
            if (!board[0][i].isEmpty() && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
                TurnText.setText(board[0][i] + " Wins!");
                return;
            }
        }

        // Check diagonals
        if (!board[0][0].isEmpty() && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])) {
            TurnText.setText(board[0][0] + " Wins!");
            return;
        }

        if (!board[0][2].isEmpty() && board[0][2].equals(board[1][1]) && board[0][2].equals(board[2][0])) {
            TurnText.setText(board[0][2] + " Wins!");
            return;
        }

        // Check for draw
        boolean isDraw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j].isEmpty()) {
                    isDraw = false;
                    break;
                }
            }
        }

        if (isDraw) {
            TurnText.setText("It's a draw!");
        }
    }

    @FXML
    private void handeMainMenuButtonClick() {
        Stage currentStage = (Stage) mainMenuButton.getScene().getWindow();
        currentStage.close();

        try {
            Parent newGamePage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/MainMenuInitialPage.fxml")));
            Stage newStage = new Stage();
            newStage.setScene(new Scene(newGamePage));
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
