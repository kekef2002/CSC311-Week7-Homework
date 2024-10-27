package edu.farmingdale.csc311week7homework;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginController {
    @FXML
    private Button create_your_account;

    private SplashScreen splashScreen;

    public void setSplashScreen(SplashScreen splashScreen) {
        this.splashScreen = splashScreen;
    }

    @FXML
    private void handleCreateAccount() {
        // Check if splashScreen is set, then switch to the registration page
        if (splashScreen != null) {
            Stage currentStage = (Stage) create_your_account.getScene().getWindow();
            splashScreen.changeScene(currentStage);  // Use the current stage
        }
    }
}
