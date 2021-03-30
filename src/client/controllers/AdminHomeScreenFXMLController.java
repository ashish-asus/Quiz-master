package client.controllers;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminHomeScreenFXMLController implements Initializable {

    @FXML
    public JFXTabPane adminTabPane;
    @FXML
    public Tab addQuizTab;
    @FXML
    public Tab addStudentTab;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
