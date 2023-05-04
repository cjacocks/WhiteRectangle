package com.example.demo;
// This comment exists to count the number of times I have had to restart IntelliJ due to scenebuilder
// Current count == 18
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WhiteRectangleMain extends Application {
    /*
    This class file should serve as the primary controller for all other classes. It will launch the game menu
    and once a game is selected, will initiate any functions or methods needed to serve the player with that game.

     */

    private static final String DATABASE_NAME = "high_score_database.db";
    @Override
    public void start (Stage stage) throws IOException {
        /*
        This is the method that actually throws up the main menu
        There are a lot of begun statements here. I cannot be arsed to remove them and honestly they are being useful
        FAR TOO OFTEN for me to be willing to remove them.

         */
        System.out.println("WhiteRectangle: fxml loader start");
        FXMLLoader fxmlLoader = new FXMLLoader(WhiteRectangleMain.class.getResource("/com/example/demo/MainMenuInitialPage.fxml"));
        System.out.println("WhiteRectangle: load scene");
        Scene scene = new Scene(fxmlLoader.load());
        System.out.println("WhiteRectangle: set title");
        stage.setTitle("White Rectangle Launcher");
        System.out.println("WhiteRectangle: set scene");
        stage.setScene(scene);
        System.out.println("WhiteRectangle: showing scene");
        stage.show();
    }


    public static void main(String[]args) {
        try {
            File file = new File(DATABASE_NAME);
            if (!file.exists()) {
                System.out.println("WhiteRectangle: Database not initialized, initializing a new DB.");
                setupDatabase();
            } else {
                System.out.println("WhiteRectangle: Database already present, proceeding.");
            }
        } catch (SQLException e) {
            System.err.println("Error setting up DB: " + e.getMessage());
        }

        System.out.println("WhiteRectangle: Running Main Method Now");
        launch();
    }

    private static void setupDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_NAME);

        // Create DiceGame highscores table
        String diceGameSql = "CREATE TABLE dice_game_highscores ("
                + "id INTEGER PRIMARY KEY,"
                + "date TEXT,"
                + "score REAL"
                + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(diceGameSql);
        }

        // Create Rock Paper Scissors game table
        String rpsGameSql = "CREATE TABLE rps_game ("
                + "id INTEGER PRIMARY KEY,"
                + "date TEXT,"
                + "player1 INT,"
                + "player2 INT,"
                + "result INT"
                + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(rpsGameSql);
        }

        // Close database connection
        connection.close();
    }

    private void updateDB_RPS(int turn, int player, int adversary) {
        String date = getDate();
    }

    private void updateDB_Dice(int bank) {
        String date = getDate();
    }

    private String getDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = currentDate.format(formatter);
        return formattedDate;
    }
}