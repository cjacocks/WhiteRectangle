import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.*;

public class MemoryGame extends Application {
    private static final int GRID_SIZE = 5;
    private Button[][] gridButtons = new Button[GRID_SIZE][GRID_SIZE];
    private Map<Integer, Button> numberButtons = new HashMap<>();
    private int currentNumber = 1;
    private Label victoryLabel = new Label();
    private Label instructionsLabel = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Memory Game");

        Pane root = createRootPane();
        Scene scene = new Scene(root, 700, 700); // Resize the root

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Pane createRootPane() {
        GridPane grid = createGrid();

        Button startButton = new Button("Start Game");
        startButton.setOnAction(e -> startGame());

        victoryLabel.setText(""); // Initialize the label with an empty string
        victoryLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        instructionsLabel.setText("Click 'Start Game' to begin. Memorize the numbers 1-5 that appear on the grid for 3 seconds. Then, click the correct boxes in order from 1-5 to win. Upon winning/losing, the game resets.");
        instructionsLabel.setStyle("-fx-font-size: 14;");
        instructionsLabel.setWrapText(true);

        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER); // Center the grid, start button, and victory label within the window
        root.getChildren().addAll(grid, instructionsLabel, startButton, victoryLabel);
        return root;
    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setHgap(10); // Add horizontal spacing between buttons
        grid.setVgap(10); // Add vertical spacing between buttons

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                Button button = new Button();
                button.setMinSize(100, 100); // Increase button size
                button.setStyle("-fx-font-size: 24; -fx-font-weight: bold;"); // Make the numbers in the buttons bigger and bold

                int finalI = i;
                int finalJ = j;
                button.setOnAction(e -> handleButtonClick(finalI, finalJ));

                grid.add(button, i, j);
                gridButtons[i][j] = button;
            }
        }

        return grid;
    }

    private void startGame() {
        currentNumber = 1;
        clearGrid();
        Random random = new Random();
        Set<String> usedPositions = new HashSet<>();

        for (int i = 1; i <= 5; i++) {
            int row, col;
            do {
                row = random.nextInt(GRID_SIZE);
                col = random.nextInt(GRID_SIZE);
            } while (usedPositions.contains(row + "," + col));
            usedPositions.add(row + "," + col);

            Button button = gridButtons[row][col];
            button.setText(String.valueOf(i));
            numberButtons.put(i, button);
        }

        PauseTransition pause = new PauseTransition(Duration.seconds(3));
        pause.setOnFinished(e -> clearGrid());
        pause.play();
    }

    private void clearGrid() {
        for (Button[] row : gridButtons) {
            for (Button button : row) {
                button.setText("");
            }
        }
    }

    private void handleButtonClick(int i, int j) {
        Button clickedButton = gridButtons[i][j];

        if (numberButtons.get(currentNumber) == clickedButton) {
            clickedButton.setText(String.valueOf(currentNumber));
            currentNumber++;

            if (currentNumber > 5) {
                victoryLabel.setText("You won!");
                startGame();
            }
        } else {
            victoryLabel.setText("Incorrect! Try again.");
            startGame();
        }
    }
}

