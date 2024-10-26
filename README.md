# JavaFX Database Application

This JavaFX application connects to a MySQL database, providing a user interface for managing user information. The application features a splash screen, login, database operations (CRUD), and theme toggling. Each file in the project contributes specific functionality to achieve these goals.

## File Descriptions

### 1. ConnDbOps.java
- **Purpose**: Handles database operations (CRUD) related to the "users" table.
- **Key Functions**:
  - `connectToDatabase()`: Establishes a connection to the database, creates the "users" table if it does not exist, and defines the schema for user information.
  - `insertUser(Person person)`: Inserts a new user record into the database with details from a `Person` object.
  - `updateUser(Person person)`: Updates an existing user's information in the database.
  - `deleteUser(int id)`: Deletes a user record based on the provided ID.

### 2. App.java
- **Purpose**: Main application entry point.
- **Key Functions**:
  - `start(Stage primaryStage)`: Loads and displays the splash screen as the initial interface. It also initializes the `SplashScreen` controller.
  - `main(String[] args)`: Launches the JavaFX application.

### 3. DB_Application.java
- **Purpose**: Sets up the main application window and GUI functionalities, such as theming and a menu bar.
- **Key Functions**:
  - `showScene1()`: Initializes and displays the splash screen, setting up a theme toggle.
  - `changeScene()`: Transition effect to load the main database interface after the splash screen.
  - `createMenu(Scene scene)`: Creates a menu with database and theme options (add, edit, delete records; toggle dark/light theme).
  - `toggleTheme(Scene scene)`: Switches between dark and light themes for the application interface.

### 4. DB_GUI_Controller.java
- **Purpose**: Controller for the database interface, handling CRUD operations and table view updates.
- **Key Functions**:
  - `initialize()`: Sets up the `TableView` columns for displaying user data and establishes a database connection.
  - `addNewRecord()`: Adds a new user to the table view and database based on input from form fields.
  - `editRecord()`: Updates selected user data in both the table view and database.
  - `deleteRecord()`: Deletes the selected user from the table view and database.
  - `showImage()`: Allows users to upload a profile picture.
  - `selectedItemTV()`: Loads selected user details into form fields for editing.
  - `clearForm()`: Clears all form fields.

### 5. HelloController.java
- **Purpose**: (Commented out code) Controller potentially for a "Hello" page with a welcome message.
- **Key Functions**: Contains a function that changes text to "Welcome to JavaFX Application!"

### 6. LoginController.java
- **Purpose**: Controller for the login screen.
- **Key Functions**:
  - `onHelloButtonClick()`: Updates a label with a welcome message when the login button is clicked.

### 7. Person.java
- **Purpose**: Model class representing a "Person" with fields for user information.
- **Attributes**:
  - `id`, `firstName`, `lastName`, `dept`, `major`: Basic personal and academic details.
  - `profilePicturePath`: Stores the file path to the user's profile picture.
- **Methods**: Standard getter and setter methods for each attribute.

### 8. SplashScreen.java
- **Purpose**: Handles the splash screen display and transition to the login screen.
- **Key Functions**:
  - `initialize(Stage primaryStage)`: Starts a fade-out transition effect and then calls `loadLoginScreen()` after the splash screen animation.
  - `loadLoginScreen(Stage primaryStage)`: Loads and sets the login screen after the splash screen finishes.
