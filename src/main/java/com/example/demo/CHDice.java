package com.example.demo;

/* CHDice.java
 * by Caleb Hawn
 * 5/2-3/2023
 * --------------------
 * This program's logic is based on a CLI game I wrote
 * in Python 3 in 2017 called CHDice.py. Here, it is
 * converted to JavaFX with a GUI. As such, I have
 * included the original CLI outputs, along with an original
 * GUI using the Java libraries listed below.
 * Enjoy losing money! -CabeoC
 */

// ══════════ Imports ══════════

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// ══════════ GUI ══════════

public class CHDice extends Application {
    // Bank
    private double money = 500.00; // Current amount of monies in le bank, $500.00 by default.

    @Override
    public void start(Stage stage) {
        // ══════════ CLI Header ══════════
        System.out.println("   ╔════════╗╔════════╗╔════════╗");
        System.out.println("   ║ ● ● ●  ║║ ●    ╔═╝╚═╗●   ● ║");
        System.out.println("   ║ Welcome║║to the║Dice║game! ║");
        System.out.println("   ║ ● ● ●  ║║     ●╚═╗╔═╝●   ● ║");
        System.out.println("   ╚════════╝╚════════╝╚════════╝");
        System.out.println("░▫Rules: You have three rolls of two░\n░ dice to match a number you select.░");
        System.out.println("▒▫If you guess on the…              ▒");
        System.out.println("▒ 1st roll, you win 2x your wager.  ▒");
        System.out.println("▒ 2nd roll, you win 1½x your wager. ▒");
        System.out.println("▒ 3rd roll, you win your wager.     ▒");
        System.out.println("▓▫Wager 0 to quit and save the game.▓\n");

        // Set the title of the window
        stage.setTitle("A Game o' Dice");

        // Static Bank Label
        Label staticBank = new Label("Bank: $");
        staticBank.setFont(new Font("Times New Roman", 30));
        staticBank.setTextFill(Color.web("blue"));
        staticBank.setPadding(new Insets(10, 10, 10, 10));
        staticBank.relocate(10, 10);
        staticBank.setEffect(new DropShadow(10, Color.web("#6ca4bc")));
        // Shows as "Bank:" in top left of window.
        // Reference for relocate method: v: ↔, v1: ↕

        // Dynamic Bank Label
        Label dynamicBank = new Label(String.format("%.2f", money)); // Set bank amount.
        dynamicBank.setPadding(new Insets(10, 10, 10, 10));
        dynamicBank.relocate(120, 10);
        dynamicBank.setFont(new Font("Times New Roman", 30));
        dynamicBank.setTextFill(Color.web("blue"));
        dynamicBank.setEffect(new DropShadow(10, Color.web("#6ca4bc")));
        // Shows current bank amount in the format "0.00" next to "Bank: $".

        // Static Wager Label
        Label staticWager = new Label("Your Wager:");
        staticWager.setFont(new Font("Times New Roman", 30));
        staticWager.setTextFill(Color.web("blue"));
        staticWager.relocate(20, 310);
        staticWager.setEffect(new DropShadow(10, Color.web("#6ca4bc")));

        // Dynamic Wager Text Field
        TextField dynamicWager = new TextField();
        dynamicWager.relocate(220, 320);
        dynamicWager.setEffect(new DropShadow(10, Color.web("blue")));

        // Static Guess Text Field
        Label staticGuess = new Label("Your Guess:");
        staticGuess.setFont(new Font("Times New Roman", 30));
        staticGuess.setTextFill(Color.web("blue"));
        staticGuess.relocate(20, 360);
        staticGuess.setEffect(new DropShadow(10, Color.web("#6ca4bc")));

        // Dynamic Guess Text Field
        TextField dynamicGuess = new TextField();
        dynamicGuess.relocate(220, 370);
        dynamicGuess.setEffect(new DropShadow(10, Color.web("blue")));

        // Static Dice
        // Roll 1 Dice A
        Rectangle staticRoll1DiceA = new Rectangle(50, 50);
        staticRoll1DiceA.setArcWidth(20);
        staticRoll1DiceA.setArcHeight(20);
        staticRoll1DiceA.setStrokeWidth(5);
        staticRoll1DiceA.setStroke(Color.BLACK);
        staticRoll1DiceA.setFill(Color.TRANSPARENT);
        staticRoll1DiceA.relocate(40, 90);
        // Roll 1 Dice B
        Rectangle staticRoll1DiceB = new Rectangle(50, 50);
        staticRoll1DiceB.setArcWidth(20);
        staticRoll1DiceB.setArcHeight(20);
        staticRoll1DiceB.setStrokeWidth(5);
        staticRoll1DiceB.setStroke(Color.BLACK);
        staticRoll1DiceB.setFill(Color.TRANSPARENT);
        staticRoll1DiceB.relocate(150, 90);
        // Roll 2 Dice A
        Rectangle staticRoll2DiceA = new Rectangle(50, 50);
        staticRoll2DiceA.setArcWidth(20);
        staticRoll2DiceA.setArcHeight(20);
        staticRoll2DiceA.setStrokeWidth(5);
        staticRoll2DiceA.setStroke(Color.BLACK);
        staticRoll2DiceA.setFill(Color.TRANSPARENT);
        staticRoll2DiceA.relocate(40, 160);
        // Roll 2 Dice B
        Rectangle staticRoll2DiceB = new Rectangle(50, 50);
        staticRoll2DiceB.setArcWidth(20);
        staticRoll2DiceB.setArcHeight(20);
        staticRoll2DiceB.setStrokeWidth(5);
        staticRoll2DiceB.setStroke(Color.BLACK);
        staticRoll2DiceB.setFill(Color.TRANSPARENT);
        staticRoll2DiceB.relocate(150, 160);
        // Roll 3 Dice A
        Rectangle staticRoll3DiceA = new Rectangle(50, 50);
        staticRoll3DiceA.setArcWidth(20);
        staticRoll3DiceA.setArcHeight(20);
        staticRoll3DiceA.setStrokeWidth(5);
        staticRoll3DiceA.setStroke(Color.BLACK);
        staticRoll3DiceA.setFill(Color.TRANSPARENT);
        staticRoll3DiceA.relocate(40, 230);
        // Roll 3 Dice B
        Rectangle staticRoll3DiceB = new Rectangle(50, 50);
        staticRoll3DiceB.setArcWidth(20);
        staticRoll3DiceB.setArcHeight(20);
        staticRoll3DiceB.setStrokeWidth(5);
        staticRoll3DiceB.setStroke(Color.BLACK);
        staticRoll3DiceB.setFill(Color.TRANSPARENT);
        staticRoll3DiceB.relocate(150, 230);
        // Reference for relocate method: v: ↔, v1: ↕

        // Static Plus Symbols
        Label plus1 = new Label("+");
        plus1.setFont(new Font("Times New Roman", 70));
        plus1.setTextFill(Color.web("black"));
        plus1.relocate(100, 70);
        plus1.setEffect(new DropShadow(10, Color.web("gray")));
        Label plus2 = new Label("+");
        plus2.setFont(new Font("Times New Roman", 70));
        plus2.setTextFill(Color.web("black"));
        plus2.relocate(100, 140);
        plus2.setEffect(new DropShadow(10, Color.web("gray")));
        Label plus3 = new Label("+");
        plus3.setFont(new Font("Times New Roman", 70));
        plus3.setTextFill(Color.web("black"));
        plus3.relocate(100, 210);
        plus3.setEffect(new DropShadow(10, Color.web("gray")));

        // Static Equal Signs
        Label equal1 = new Label("=");
        equal1.setFont(new Font("Times New Roman", 70));
        equal1.setTextFill(Color.web("black"));
        equal1.relocate(220, 70);
        equal1.setEffect(new DropShadow(10, Color.web("gray")));
        Label equal2 = new Label("=");
        equal2.setFont(new Font("Times New Roman", 70));
        equal2.setTextFill(Color.web("black"));
        equal2.relocate(220, 140);
        equal2.setEffect(new DropShadow(10, Color.web("gray")));
        Label equal3 = new Label("=");
        equal3.setFont(new Font("Times New Roman", 70));
        equal3.setTextFill(Color.web("black"));
        equal3.relocate(220, 210);
        equal3.setEffect(new DropShadow(10, Color.web("gray")));

        // Dynamic Dice Labels
        // Roll 1 Dice A
        Label dynamicRoll1DiceA = new Label("∙");
        dynamicRoll1DiceA.setFont(new Font("Times New Roman", 40));
        dynamicRoll1DiceA.setTextFill(Color.web("black"));
        dynamicRoll1DiceA.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll1DiceA.relocate(55, 90); // v is +15 adjacent to dice position.
        // Roll 1 Dice B
        Label dynamicRoll1DiceB = new Label("∙");
        dynamicRoll1DiceB.setFont(new Font("Times New Roman", 40));
        dynamicRoll1DiceB.setTextFill(Color.web("black"));
        dynamicRoll1DiceB.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll1DiceB.relocate(165, 90);
        // Roll 2 Dice A
        Label dynamicRoll2DiceA = new Label("∙");
        dynamicRoll2DiceA.setFont(new Font("Times New Roman", 40));
        dynamicRoll2DiceA.setTextFill(Color.web("black"));
        dynamicRoll2DiceA.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll2DiceA.relocate(55, 160);
        // Roll 2 Dice B
        Label dynamicRoll2DiceB = new Label("∙");
        dynamicRoll2DiceB.setFont(new Font("Times New Roman", 40));
        dynamicRoll2DiceB.setTextFill(Color.web("black"));
        dynamicRoll2DiceB.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll2DiceB.relocate(165, 160);
        // Roll 3 Dice A
        Label dynamicRoll3DiceA = new Label("∙");
        dynamicRoll3DiceA.setFont(new Font("Times New Roman", 40));
        dynamicRoll3DiceA.setTextFill(Color.web("black"));
        dynamicRoll3DiceA.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll3DiceA.relocate(55, 230);
        // Roll 3 Dice B
        Label dynamicRoll3DiceB = new Label("∙");
        dynamicRoll3DiceB.setFont(new Font("Times New Roman", 40));
        dynamicRoll3DiceB.setTextFill(Color.web("black"));
        dynamicRoll3DiceB.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll3DiceB.relocate(165, 230);
        // Roll 1 Total
        Label dynamicRoll1Total = new Label("##");
        dynamicRoll1Total.setFont(new Font("Times New Roman", 40));
        dynamicRoll1Total.setTextFill(Color.web("black"));
        dynamicRoll1Total.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll1Total.relocate(270, 90);
        // Roll 2 Total
        Label dynamicRoll2Total = new Label("##");
        dynamicRoll2Total.setFont(new Font("Times New Roman", 40));
        dynamicRoll2Total.setTextFill(Color.web("black"));
        dynamicRoll2Total.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll2Total.relocate(270, 160);
        // Roll 3 Total
        Label dynamicRoll3Total = new Label("##");
        dynamicRoll3Total.setFont(new Font("Times New Roman", 40));
        dynamicRoll3Total.setTextFill(Color.web("black"));
        dynamicRoll3Total.setEffect(new DropShadow(10, Color.web("gray")));
        dynamicRoll3Total.relocate(270, 230);
        // Reference for relocate method: v: ↔, v1: ↕

        Label message = new Label(); // Message to display results and errors.
        message.setFont(new Font("Times New Roman", 20));
        message.setTextFill(Color.web("yellow"));
        message.setEffect(new DropShadow(10, Color.web("black")));
        staticBank.setPadding(new Insets(10, 10, 10, 10));
        message.relocate(20, 450);

        // Button
        Button button = new Button("Dewit");
        button.relocate(280, 415);
        button.setOnAction(event -> { // Game runs when button's pushed.

            // ══════════ Game Logic ══════════

            // Error check user input.
            try { // Check if the wagerText double.
                double wager = Double.parseDouble(dynamicWager.getText()); // Convert wager.
            } catch (NumberFormatException e) { // if not a double, error.
                message.setTextFill(Color.web("red"));
                message.setText("The wager must be a valid number.");
                System.out.println("The wager must be a double.");
                return;
            }
            try { // Check if the guessText is an int
                int guess = Integer.parseInt(dynamicGuess.getText()); // Convert guess.
            } catch (NumberFormatException e) { // if not an int, error.
                message.setTextFill(Color.web("red"));
                message.setText("The guess must be a whole number.");
                System.out.println("The guess must be an integer.");
                return;
            }

            // Convert user input from Strings to numbers.
            double wager = Double.parseDouble(dynamicWager.getText()); // convert
            int guess = Integer.parseInt(dynamicGuess.getText());

            System.out.println(guess);

            // Confirm user guess is a good guess. Two dice add between 2 & 12.
            if (!(guess >=2 && guess <= 12)) {
                message.setTextFill(Color.web("red"));
                message.setText("Your guess must be between 2 and 12.");
                System.out.println("The guess must be between 2 and 12.");
                return;
            } else if (wager > money) { // Wager can't be above current bank amount.
                message.setTextFill(Color.web("red"));
                message.setText("Can't go into debt!");
                return;
            } // end checks

            // Roll of le Dice
            // Roll 1
            int[] roll1 = roll(); // Roll the dice thrice.
            dynamicRoll1DiceA.setText(Integer.toString(roll1[0])); // convert int to string
            dynamicRoll1DiceB.setText(Integer.toString(roll1[1])); // and set the text of the
            dynamicRoll1Total.setText(Integer.toString(roll1[2])); // dynamic labels.
            // Roll 2
            int[] roll2 = roll(); // store results in array variables.
            dynamicRoll2DiceA.setText(Integer.toString(roll2[0]));
            dynamicRoll2DiceB.setText(Integer.toString(roll2[1]));
            dynamicRoll2Total.setText(Integer.toString(roll2[2]));
            // Roll 3
            int[] roll3 = roll();
            dynamicRoll3DiceA.setText(Integer.toString(roll3[0]));
            dynamicRoll3DiceB.setText(Integer.toString(roll3[1]));
            dynamicRoll3Total.setText(Integer.toString(roll3[2]));

            // Check
            if (guess == roll1[2]) { // If guess matches first roll,
                double win = wager * 2;    // Double the money.
                System.out.println("Guessed on the first roll. You won two times your wager.");
                message.setTextFill(Color.web("green"));
                message.setText("Right on first roll! You won $" + String.format("%.2f", win));
                money += win; // Add win to money.
            }
            else if (guess == roll2[2]) {   // If guess is second roll,
                double win = wager + (wager / 2); //  Get your wager plus half.
                System.out.println("Guessed on the second roll. You won your wager plus half.");
                message.setTextFill(Color.web("green"));
                message.setText("Right on second roll! You won $" + String.format("%.2f", win));
                money += win; // Add win to money.
            }
            else if (guess == roll3[2]) { // If guess is third roll,
                System.out.println("Guessed on the third roll. You won your wager.");
                message.setTextFill(Color.web("green"));
                message.setText(String.format("Right on third roll! You won $" + String.format("%.2f", wager)));
                money += wager; // Add wager to money.
            }
            else { // If guess is wrong…
                System.out.println("Guessed wrong.");
                money -= wager; // Subtract wager from money.
                if (money == 0.0) { // If the bank runs dry, reset to $500.
                    message.setTextFill(Color.web("red"));
                    message.setText("Out of money! Resetting the bank…");
                    System.out.println("Out of money. Resetting the bank.");
                    money = 500;
                } else { // If bank's still alive, message it.
                    message.setTextFill(Color.web("green"));
                    message.setText("You guessed wrong. You lose $" + String.format("%.2f", wager));
                }
            } // end else

            dynamicBank.setText(String.valueOf(String.format("%.2f", money))); // Update bank label.
        }); // end button

        // Create Pane root component and add elements to it
        Pane root = new Pane(); // It's such a pane to create this root object.
        root.getChildren().addAll(staticBank, dynamicBank, staticWager, dynamicWager, staticGuess, dynamicGuess, button, message, staticRoll1DiceA, staticRoll1DiceB, staticRoll2DiceA, staticRoll2DiceB, staticRoll3DiceA, staticRoll3DiceB, plus1, plus2, plus3, equal1, equal2, equal3, dynamicRoll1DiceA, dynamicRoll1DiceB, dynamicRoll2DiceA, dynamicRoll2DiceB, dynamicRoll3DiceA, dynamicRoll3DiceB, dynamicRoll1Total, dynamicRoll2Total, dynamicRoll3Total);

        // Create Scene with root ↯
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
    } // end start

    // ══════════ Roll Function ══════════

    // Each round runs this thrice. I'd rather not make an object class.
    private static int[] roll() {
        // Pick a number between 2-12, twice.
        int dice1 = (int) (Math.random() * 6 +1);
        int dice2 = (int) (Math.random() * 6 +1);

        int total = dice1 + dice2; // Adds both rolls together.

        // Output the dice to CLI.
        System.out.println("You rolled " + dice1 + " and " + dice2 + ", which adds up to " + total);
        System.out.println("\t\t ╔═══╗ ╔═══╗");
        System.out.println("\t\t ║ " + dice1 + " ║ ║ " + dice2 + " ║ = " + total);
        System.out.println("\t\t ╚═══╝ ╚═══╝");

        // Return an array to hold the results.
        return new int[] {dice1, dice2, total};
        /* Usage:
         * int[] results = roll();
         * dice1 = results[0];
         * dice2 = results[1];
         * total = results[2];
         */
    } // end roll

    //public static void main(String[] args) {launch(args);}
}