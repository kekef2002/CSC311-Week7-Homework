package edu.farmingdale.csc311week7homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("splash_screen.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 850, 560);
            primaryStage.setScene(scene);
            primaryStage.show();

            // Initialize the splash screen
            SplashScreen splashScreen = loader.getController();
            splashScreen.initialize(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
