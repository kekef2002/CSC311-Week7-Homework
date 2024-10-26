package edu.farmingdale.csc311week7homework;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class DB_Application extends Application {

    private Stage primaryStage;
    private boolean isDarkMode = false;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setResizable(false);
        showScene1();
    }

    private void showScene1() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("db_interface_gui.fxml"));
            Scene scene = new Scene(root, 850, 560);
            createMenu(scene);
            toggleTheme(scene);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createMenu(Scene scene) {
        MenuBar menuBar = new MenuBar();

        // Database Menu
        Menu dbMenu = new Menu("Database");
        MenuItem addItem = new MenuItem("Add Person");
        MenuItem editItem = new MenuItem("Edit Person");
        MenuItem deleteItem = new MenuItem("Delete Person");
        MenuItem uploadPicItem = new MenuItem("Upload Profile Picture");

        // Adding Actions
        addItem.setOnAction(e -> openAddForm());
        editItem.setOnAction(e -> openEditForm());
        deleteItem.setOnAction(e -> handleDelete());
        uploadPicItem.setOnAction(e -> uploadProfilePicture());

        // Setting Shortcuts
        addItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
        editItem.setAccelerator(new KeyCodeCombination(KeyCode.E, KeyCombination.CONTROL_DOWN));
        deleteItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));

        // Adding items to Database Menu
        dbMenu.getItems().addAll(addItem, editItem, deleteItem, uploadPicItem);

        // Theme Menu
        Menu themeMenu = new Menu("Theme");
        MenuItem toggleThemeItem = new MenuItem("Toggle Dark/Light Theme");
        toggleThemeItem.setOnAction(e -> toggleTheme(scene));
        themeMenu.getItems().add(toggleThemeItem);

        menuBar.getMenus().addAll(dbMenu, themeMenu);

        // Update to add MenuBar to AnchorPane root
        AnchorPane root = (AnchorPane) scene.getRoot();
        root.getChildren().add(0, menuBar);
        AnchorPane.setTopAnchor(menuBar, 0.0);
    }

    // Toggle between dark and light themes
    private void toggleTheme(Scene scene) {
        scene.getStylesheets().clear();
        if (isDarkMode) {
            scene.getStylesheets().add(getClass().getResource("light-theme.css").toExternalForm());
        } else {
            scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        }
        isDarkMode = !isDarkMode;
    }

    private void openAddForm() {
        System.out.println("Open Add Form");
    }

    private void openEditForm() {
        System.out.println("Open Edit Form");
    }

    private void handleDelete() {
        System.out.println("Delete Person");
    }

    private void uploadProfilePicture() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            System.out.println("Profile picture set to: " + selectedFile.getAbsolutePath());
        }
    }
}
