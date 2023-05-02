package com.example.demo;

/* CHDice
 * by Caleb Hawn
 * 5/2/2023
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.Random;

public class CHDice extends Application {
    @Override
    public void start(Stage stage) {
        // Variables
        int roll1a = 0, roll1b = 0, total1 = 0; // roll 1 🎲 + 🎲 = total
        int roll2a = 0, roll2b = 0, total2 = 0; // roll 2
        int roll3a = 0, roll3b = 0, total3 = 0; // roll 3

        double money = 0.0; // current amount of monies

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
        Label dynamicBank = new Label("0.00"); // TODO: currently a placeholder
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
        dynamicWager.setOnAction(event -> {
            System.out.println(dynamicWager.getText());
            dynamicBank.setText(dynamicWager.getText());
        });

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
        dynamicGuess.setOnAction(event -> {
            System.out.println(dynamicGuess.getText());
            dynamicBank.setText(dynamicGuess.getText());
        });

        // Button
        Button button = new Button("Dewit");
        button.relocate(200, 450);
        button.setOnAction(event -> {
            System.out.println(dynamicGuess.getText());
            dynamicBank.setText(dynamicGuess.getText());
        });

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

        // Logo, for fun
        // Image logo = new Image("https://upload.wikimedia.org/wikipedia/en/d/d1/Dalton_State_College_logo.png");

        // Create Pane root component and add elements to it
        Pane root = new Pane(); // It's such a pane to create this root object.
        root.getChildren().addAll(staticBank, dynamicBank, staticWager, dynamicWager, staticGuess, dynamicGuess, button, staticRoll1DiceA, staticRoll1DiceB, staticRoll2DiceA, staticRoll2DiceB, staticRoll3DiceA, staticRoll3DiceB, plus1, plus2, plus3, equal1, equal2, equal3);

        // Create Scene with root ↯
        Scene scene = new Scene(root, 400, 500);
        stage.setScene(scene);
        stage.show();
    }
    //public static void main(String[] args) {launch(args);}
}
// TODO: make all 6 dice
// TODO: wager