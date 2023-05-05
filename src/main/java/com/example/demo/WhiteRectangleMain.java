package com.example.demo;
// This comment exists to count the number of times I have had to restart IntelliJ due to scene builder
// Current count == 18

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class WhiteRectangleMain extends Application {
    /*
    This class file should serve as the primary controller for all other classes. It will launch the game menu
    and once a game is selected, will initiate any functions or methods needed to serve the player with that game.

     */

    protected static final String DATABASE_NAME = "jdbc:sqlite:high_score_database.db";
    /*
    These are for use when debugging features.
    These are not TOTALLY implemented and may be replaced with a config file later.
    Actually they definitely will
    TODO - make config files
    */
    // Enables additional logging related to dice_game_highscores table
    protected static boolean debugDice = false;
    // Enables additional logging related to rps_game table.
    protected static boolean debugRPS = false;
    // Disables launching of
    protected static boolean disableLaunch = false;
    @Override
    public void start (Stage stage) throws IOException {
        /*
        This is the method that actually throws up the main menu
        There are a lot of begun statements here. I cannot be arsed to remove them, and honestly they are being useful
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

        ifDebug();

        if (!disableLaunch) {
            System.out.println("WhiteRectangle: Running Main Method Now");
            launch();
        } else {
            System.out.println("WhiteRectangle: Running in special debug mode. GUI disabled.");
        }
    }

    private static void setupDatabase() throws SQLException {
        Connection connection = DriverManager.getConnection(DATABASE_NAME);

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
                + "turns INT,"
                + "player INT,"
                + "adversary INT"
                + ")";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(rpsGameSql);
        }

        // Close database connection
        connection.close();
    }

    protected static void updateDB_RPS(int turn, int player, int adversary) {
        String date = getDate();
        if (player + adversary <= turn) {
            if (debugRPS) {
                System.out.println("WhiteRectangle: updating table rps_game.   Date: " + date + " Turn: " + turn + " Player: " + player + " Adversary: " + adversary);
            }

            try (Connection connection = DriverManager.getConnection( DATABASE_NAME)) {
                String input = "INSERT INTO rps_game (date, turns, player, adversary) VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(input);
                preparedStatement.setString(1, date);
                preparedStatement.setInt(2, turn);
                preparedStatement.setInt(3, player);
                preparedStatement.setInt(4, adversary);
                preparedStatement.executeUpdate();
            } catch ( SQLException e) {
                System.out.println(e.getMessage());
            }


        } else {
            System.out.println("WhiteRectangle: ERROR INVALID DATA: THE SUM OF PLAYERS SCORE AND ADVERSARIES SCORE IS " +
                    "GREATER THAN THE TURN COUNT");
        }
        System.out.println("WhiteRectangle: Game RPS highscores table updated");
    }

    protected static void updateDB_Dice(double bank) {
        String date = getDate();
        if (debugDice) {
            System.out.println("WhiteRectangle: updating table dice_game_highscores.   Date: " + date + " Bank: " + bank);
        }
        try (Connection connection = DriverManager.getConnection( DATABASE_NAME)) {
            String input = "INSERT INTO dice_game_highscores (date, score) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(input);
            preparedStatement.setString(1, date);
            preparedStatement.setDouble(2,bank);
            preparedStatement.executeUpdate();
        } catch ( SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return currentDate.format(formatter);
    }

    private static void ifDebug() {
        if (debugDice) {
            System.out.println("WhiteRectangle: Running in debug mode. Targeting dice db table");
            updateDB_Dice(2500.00);
            updateDB_Dice(9900.23);
            updateDB_Dice(2508.00);
            updateDB_Dice(2590.00);
            updateDB_Dice(7483.00);
            updateDB_Dice(2500.80);
        } else if (debugRPS) {
            System.out.println("WhiteRectangle: Running in debug mode. Targeting Rock Paper Scissor db table");
            updateDB_RPS(8,3,1);
            updateDB_RPS(9,2,3);
            updateDB_RPS(3,3,0);

        } else {
            System.out.println("WhiteRectangle: Running in normal mode with respect to db debug states.");
        }
    }
}