package client.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

public class AdminStudentTab {
    @FXML
    private VBox formContainer;
    @FXML
    private JFXTextField firstName;
    @FXML
    private JFXTextField lastName;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField mobileNumber;
    @FXML
    private JFXRadioButton male;
    @FXML
    private JFXRadioButton female;
    @FXML
    private JFXButton saveButton;
    @FXML
    private TableView studentTable;
    @FXML
    private TableColumn studentIdColumn;
    @FXML
    private TableColumn firstNameColumn;
    @FXML
    private TableColumn lastNameColumn;
    @FXML
    private TableColumn emailColumn;
    @FXML
    private TableColumn passwordColumn;
    @FXML
    private TableColumn mobileNumberColumn;
    @FXML
    private TableColumn genderColumn;

    public void saveStudent(ActionEvent event) {
    }
}
