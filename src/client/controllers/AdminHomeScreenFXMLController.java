package client.controllers;

import com.jfoenix.controls.JFXTabPane;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
        try {
            Parent node= FXMLLoader.load(getClass().getResource("/client/FXML/AddQuizFXML.fxml"));
            addQuizTab.setContent(node);

            Parent node1= FXMLLoader.load(getClass().getResource("/client/FXML/AdminStudentTab.fxml"));
            addStudentTab.setContent(node1);

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
