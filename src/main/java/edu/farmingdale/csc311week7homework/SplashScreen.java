package edu.farmingdale.csc311week7homework;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen {
    public void initialize(Stage primaryStage) {
        // Create FadeTransition
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(3), primaryStage.getScene().getRoot());
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.0);
        fadeTransition.setOnFinished(event -> loadLoginScreen(primaryStage));
        fadeTransition.play();
    }

    private void loadLoginScreen(Stage primaryStage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-page.fxml"));
            Parent loginRoot = loader.load();
            primaryStage.setScene(new Scene(loginRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

