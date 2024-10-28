package edu.farmingdale.csc311week7homework;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashScreen {
    public void initialize(Stage primaryStage) {
        // Set up an initial scene if not already set
        if (primaryStage.getScene() == null) {
            primaryStage.setScene(new Scene(new Parent() {})); // Temporary empty scene
        }

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

            // Get controller and set the SplashScreen instance
            LoginController loginController = loader.getController();
            loginController.setSplashScreen(this);

            primaryStage.setScene(new Scene(loginRoot));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeScene(Stage secondaryStage) {  // Added Stage parameter
        try {
            Parent newRoot = FXMLLoader.load(getClass().getResource("registration-page.fxml"));

            Scene currentScene = secondaryStage.getScene();
            if (currentScene != null) {
                Parent currentRoot = currentScene.getRoot();
                currentScene.getStylesheets().add("style2.css");

                FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), currentRoot);
                fadeOut.setFromValue(1);
                fadeOut.setToValue(0);
                fadeOut.setOnFinished(e -> {
                    Scene newScene = new Scene(newRoot, 850, 636);
                    secondaryStage.setScene(newScene);
                });

                fadeOut.play();
            } else {
                secondaryStage.setScene(new Scene(newRoot, 850, 560));
            }
            secondaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
