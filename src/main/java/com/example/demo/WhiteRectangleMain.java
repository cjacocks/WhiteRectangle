package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WhiteRectangleMain extends Application {
    /*
    This class file should serve as the primary contoller for all other classes. It will launch the game menu
    and once a game is selected, will initiate any functions or methods needed to serve the player with that game.

    This class may not even be needed. TBD
     */

    // TODO - Add Initial start page that asks user whether they want to play and new game, load a game, or view scoreboards
    // TODO - Add New Game select page
    // TODO - Add Load Game select Page
    // TODO - Add View High Scores Game Select Page

    @Override
    public void start (Stage stage) throws IOException {
        System.out.println("WhiteRectangle: fxml loader start");
        FXMLLoader fxmlLoader = new FXMLLoader(WhiteRectangleMain.class.getResource("MainMenuInitialPage.fxml"));
        System.out.println("WhiteRectangle: load scene");
        Scene scene = new Scene(fxmlLoader.load());
        System.out.println("WhiteRectangle: set title");
        stage.setTitle("Testing");
        System.out.println("WhiteRectangle: set scene");
        stage.setScene(scene);
        System.out.println("WhiteRectangle: showing scene");
        stage.show();
    }


    public static void main(String[]args) {
        System.out.println("WhiteRectangle: Running Main Method Now");
        launch();
        // TODO -- Make this run the start page
    }


}