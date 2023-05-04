package com.example.demo;
// This comment exists to count the number of times I have had to restart IntelliJ due to scenebuilder
// Current count == 18
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WhiteRectangleMain extends Application {
    /*
    This class file should serve as the primary controller for all other classes. It will launch the game menu
    and once a game is selected, will initiate any functions or methods needed to serve the player with that game.

    This class may not even be needed. TBD
     */

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
        System.out.println("WhiteRectangle: Running Main Method Now");
        launch();
    }
}