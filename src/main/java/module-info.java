module edu.farmingdale.csc311week7homework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens edu.farmingdale.csc311week7homework to javafx.fxml;
    opens edu.farmingdale.csc311week7homework.db to javafx.fxml;
    exports edu.farmingdale.csc311week7homework;
}