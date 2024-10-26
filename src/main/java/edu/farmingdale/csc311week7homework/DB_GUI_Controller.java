package edu.farmingdale.csc311week7homework;

import edu.farmingdale.csc311week7homework.db.ConnDbOps;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class DB_GUI_Controller implements Initializable {

    private final ObservableList<Person> data = FXCollections.observableArrayList();
    private ConnDbOps database = new ConnDbOps();

    @FXML
    TextField first_name, last_name, department, major;
    @FXML
    private TableView<Person> tv;
    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn, tv_ln, tv_dept, tv_major;
    @FXML
    ImageView img_view;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_dept.setCellValueFactory(new PropertyValueFactory<>("dept"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));

        database.connectToDatabase(); // Establish connection
        tv.setItems(data);  // Assuming you load data from database here
    }

    @FXML
    protected void addNewRecord() {
        Person newPerson = new Person(
                data.size() + 1,
                first_name.getText(),
                last_name.getText(),
                department.getText(),
                major.getText()
        );
        data.add(newPerson);
        database.insertUser(newPerson);  // Add to the database
        clearForm();  // Clear form fields
    }

    @FXML
    protected void editRecord() {
        Person selected = tv.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setFirstName(first_name.getText());
            selected.setLastName(last_name.getText());
            selected.setDept(department.getText());
            selected.setMajor(major.getText());
            database.updateUser(selected);  // Update in database
            tv.refresh();  // Refresh TableView display
        }
    }

    @FXML
    protected void deleteRecord() {
        Person selected = tv.getSelectionModel().getSelectedItem();
        if (selected != null) {
            database.deleteUser(selected.getId());  // Remove from database
            data.remove(selected);  // Remove from TableView
        }
    }

    @FXML
    public void closeApplication() {
        System.exit(0);  // Close application
    }

    @FXML
    protected void showImage() {
        File file = new FileChooser().showOpenDialog(img_view.getScene().getWindow());
        if (file != null) {
            img_view.setImage(new Image(file.toURI().toString()));
            Person selected = tv.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setProfilePicturePath(file.getAbsolutePath());
            }
        }
    }

    @FXML
    protected void selectedItemTV() {
        Person p = tv.getSelectionModel().getSelectedItem();
        first_name.setText(p.getFirstName());
        last_name.setText(p.getLastName());
        department.setText(p.getDept());
        major.setText(p.getMajor());
    }

    @FXML
    protected void clearForm() {
        first_name.clear();
        last_name.clear();
        department.clear();
        major.clear();
    }
}
