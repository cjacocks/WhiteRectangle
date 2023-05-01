package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class RockPaperScissorsGame_Controller {

    // Initializes int values that I need to have to do some math things, but that I also apparently need in order to
    // manually set the data in the labels even though im declaring it in the jfx bc go fucking figure lets do things
    // twice like cavemen.
    // This could have been a block comment. Meh -- Chis
    private int playerScore = 0;
    private int adversaryScore = 0;
    private int roundInt = 1;
    @FXML
    private Button rockButton;

    @FXML
    private Button paperButton;

    @FXML
    private Button scissorsButton;

    @FXML
    private Label playerScoreLabel;

    @FXML
    private Label adversaryScoreLabel;

    @FXML
    private Label roundDisplayLabel;

    @FXML
    private Label advMoveLabel;

    @FXML
    private void handleRockButtonClick() {
        turnCalc(1);
    }

    @FXML
    private void handlePaperButtonClick() {
        turnCalc(2);
    }

    @FXML
    private void handleScissorsButtonClick() {
        turnCalc(3);
    }

    /*
    Remember me raging about having to do things twice? Well here you fuckign go. For some reason everything was still
    initializing as null be defualt and java did not like that. So we get to hold its hand like a school child in walmart
    and tell it what we have already told it multiple times but it still didnt listen and instead stuck its hand on the
    stove becuase... rebellion? IDk, we were all 5 once.
    -- Chris
     */
    @FXML
    public void initialize() {
        playerScoreLabel.setText(Integer.toString(playerScore));
        adversaryScoreLabel.setText(Integer.toString(adversaryScore));
        roundDisplayLabel.setText(Integer.toString(roundInt));
    }

    private void turnCalc(int playerMove) {
        // Key:
        // 1 = Rock
        // 2 = Paper
        // 3 = Scissors
        Random random = new Random();
        int advMove = random.nextInt(3) + 1;
        System.out.println("WhiteRectangle: R.P.S.G.: Player Chose " + playerMove + " and adversary chose " + advMove + ".");

        // Seemed easier to make this to just pass forward when updatiugn the data in advMoveLabel.
        // Intellij rebelled against this too.
        String temp = null;
        if (advMove == 1) {
            temp = "Rock";
        } else if (advMove == 2) {
            temp = "Paper";
        } else if (advMove == 3) {
            temp = "Scissors";
        }


        /*
        Im sure as hell not putting a comment in each of these.
        Each of these checks to see who should get a point, logs to console for debug bc why not, and then updates the
        labels in the visual end.

         */
        if (playerMove == advMove) {
            System.out.println("WhiteRectangle: R.P.S.G.: This round was a tie");
            // Do not change scores, add to round count.
            roundInt += 1;
            String finalTemp = temp;

            //had to encase this because apparently java is multi threaded now? Since when was that a thing?
            // Same thing as before. Im not typing it out a bunch of times.
            Platform.runLater(() -> {
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp);
            });
        } else if (playerMove == 1 && advMove == 3) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Player won this round");
            roundInt += 1;
            playerScore += 1;

            String finalTemp1 = temp;
            Platform.runLater(() -> {
                playerScoreLabel.setText(String.valueOf(playerScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp1);
            });

            // TODO - Add victory Condition Check

        } else if (playerMove == 2 && advMove == 1) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Player won this round");
            roundInt += 1;
            playerScore += 1;
            String finalTemp2 = temp;
            Platform.runLater(() -> {
                playerScoreLabel.setText(String.valueOf(playerScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp2);
            });
            // TODO - Add victory Condition Check

        } else if (playerMove == 3 && advMove == 2) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Player won this round");
            roundInt += 1;
            playerScore += 1;
            String finalTemp6 = temp;
            Platform.runLater(() -> {
                playerScoreLabel.setText(String.valueOf(playerScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp6);
            });
            // TODO - Add victory Condition Check

        } else if (advMove == 1 && playerMove == 3) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Adversary won this round");
            roundInt += 1;
            adversaryScore += 1;
            advMoveLabel.setText(temp);
            String finalTemp5 = temp;
            Platform.runLater(() -> {
                adversaryScoreLabel.setText(String.valueOf(adversaryScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp5);
            });
            // TODO - Add victory Condition Check

        } else if (advMove == 2 && playerMove == 1) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Adversary won this round");
            roundInt += 1;
            adversaryScore += 1;
            advMoveLabel.setText(temp);
            String finalTemp4 = temp;
            Platform.runLater(() -> {
                adversaryScoreLabel.setText(String.valueOf(adversaryScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp4);
            });
            // TODO - Add victory Condition Check

        } else if (advMove == 3 && playerMove == 2) {
            System.out.println("WhiteRectangle: R.P.S.G.: The Adversary won this round");
            roundInt += 1;
            adversaryScore += 1;
            advMoveLabel.setText(temp);
            advMoveLabel.setText("Scissors");
            String finalTemp3 = temp;
            Platform.runLater(() -> {
                adversaryScoreLabel.setText(String.valueOf(adversaryScore));
                roundDisplayLabel.setText(String.valueOf(roundInt));
                advMoveLabel.setText(finalTemp3);
            });
            // TODO - Add victory Condition Check

        } else {
            // If this runs, physics broke. Mathematically speaking this shoudl be an impossible state

            // In case of illegal moves, tuck your head between your legs and kiss your posterior goodbye
            // The end of days is probably near.
            System.out.println("Invalid move(s)");
        }
    }
}
