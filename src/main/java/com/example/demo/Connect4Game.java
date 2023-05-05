package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/*
THIS CODE WAS ALL WRITTEN BY ALEX
WE HAD ISSUES WITH OUR GITHUB REPO AND HAD TO MAKE A NEW ONE.
 */
public class Connect4Game extends Application {
    private static final int ROWS = 6;
    private static final int COLUMNS = 7;
    private static final int CIRCLE_DIAMETER = 80;
    private static final Color PLAYER_ONE_COLOR = Color.RED;
    private static final Color PLAYER_TWO_COLOR = Color.YELLOW;

    private final Circle[][] board = new Circle[COLUMNS][ROWS];
    private boolean playerOneTurn = true;
    private boolean gameEnded = false;


    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        GridPane gridPane = new GridPane();

        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS; row++) {
                Circle circle = new Circle(40);
                circle.setFill(Color.WHITE);
                circle.setStroke(Color.BLACK);
                board[col][row] = circle;

                gridPane.add(circle, col, row + 1);
            }
        }

        for (int col = 0; col < COLUMNS; col++) {
            Button button = new Button("Drop here");
            final int column = col;
            button.setOnAction(e -> dropPiece(column));

            gridPane.add(button, col, ROWS + 1);
        }

        root.setCenter(gridPane);
        root.setPrefSize(CIRCLE_DIAMETER * COLUMNS, CIRCLE_DIAMETER * (ROWS + 2));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect 4");
        primaryStage.show();
    }

    private void dropPiece(int col) {
        if (gameEnded) {
            return;
        }

        int row = ROWS - 1;
        while (row >= 0) {
            if (board[col][row].getFill() == Color.WHITE) {
                break;
            }
            row--;
        }

        if (row < 0) {
            return;
        }

        Color color = playerOneTurn ? PLAYER_ONE_COLOR : PLAYER_TWO_COLOR;
        board[col][row].setFill(color);

        if (checkForWin()) {
            gameEnded = true;
            System.out.println("Player " + (playerOneTurn ? "1" : "2") + " wins!");
            int winner = playerOneTurn ? 1 : 2;
            performActionsOnWin(winner);
        } else if (checkForDraw()) {
            gameEnded = true;
            System.out.println("Draw!");
            performActionsOnWin(3);
        } else {
            playerOneTurn = !playerOneTurn;
        }
    }

    private boolean checkForWin() {
    // Check for horizontal win
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLUMNS - 3; col++) {
            if (board[col][row].getFill() == board[col + 1][row].getFill() &&
                    board[col][row].getFill() == board[col + 2][row].getFill() &&
                    board[col][row].getFill() == board[col + 3][row].getFill() &&
                    board[col][row].getFill() != Color.WHITE) {
                return true;
            }
        }
    }
    return checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin();
}

private boolean checkRowsForWin() {
    for (int row = 0; row < ROWS; row++) {
        for (int col = 0; col < COLUMNS - 3; col++) {
            if (board[col][row].getFill() == board[col + 1][row].getFill() &&
                    board[col][row].getFill() == board[col + 2][row].getFill() &&
                    board[col][row].getFill() == board[col + 3][row].getFill() &&
                    board[col][row].getFill() != Color.WHITE) {
                return true;
            }
        }
    }
    return false;
}

    private boolean checkColumnsForWin() {
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[col][row].getFill() == board[col][row + 1].getFill() &&
                        board[col][row].getFill() == board[col][row + 2].getFill() &&
                        board[col][row].getFill() == board[col][row + 3].getFill() &&
                        board[col][row].getFill() != Color.WHITE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalsForWin() {
        return checkDiagonalTopLeftToBottomRight() || checkDiagonalBottomLeftToTopRight();
    }

    private boolean checkDiagonalTopLeftToBottomRight() {
        for (int col = 0; col < COLUMNS - 3; col++) {
            for (int row = 0; row < ROWS - 3; row++) {
                if (board[col][row].getFill() == board[col + 1][row + 1].getFill() &&
                        board[col][row].getFill() == board[col + 2][row + 2].getFill() &&
                        board[col][row].getFill() == board[col + 3][row + 3].getFill() &&
                        board[col][row].getFill() != Color.WHITE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonalBottomLeftToTopRight() {
        for (int col = 0; col < COLUMNS - 3; col++) {
            for (int row = 3; row < ROWS; row++) {
                if (board[col][row].getFill() == board[col + 1][row - 1].getFill() &&
                        board[col][row].getFill() == board[col + 2][row - 2].getFill() &&
                        board[col][row].getFill() == board[col + 3][row - 3].getFill() &&
                        board[col][row].getFill() != Color.WHITE) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkForDraw() {
        for (int col = 0; col < COLUMNS; col++) {
            for (int row = 0; row < ROWS; row++) {
                if (board[col][row].getFill() == Color.WHITE) {
                    return false;
                }
            }
        }
        return true;
    }

    private void performActionsOnWin(int winner) {
        System.out.println("Player " + winner + " wins!");
        // Perform actions based on the winner
        // For example, you can show a message box or play a sound

        Stage primaryStage = (Stage) board[0][0].getScene().getWindow();
        primaryStage.close();

        if (winner == 1) {
            try {
                Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/C4G_P1_Wins.fxml")));
                Stage stage = new Stage();
                stage.setScene(new Scene(mainMenuPage));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (winner == 2) {
            try {
                Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/C4G_P2_Wins.fxml")));
                Stage stage = new Stage();
                stage.setScene(new Scene(mainMenuPage));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (winner == 3) {
            try {
                Parent mainMenuPage = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/C4G_Draw.fxml")));
                Stage stage = new Stage();
                stage.setScene(new Scene(mainMenuPage));
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}