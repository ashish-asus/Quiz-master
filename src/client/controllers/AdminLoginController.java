package client.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminLoginController implements Initializable {
    @FXML
    public TextField adminEmail;
    @FXML
    public AnchorPane rootPane;
    @FXML
    private TextField studentEmail;
    @FXML
    private PasswordField adminPassword;
    @FXML
    private PasswordField studentPassword;
    @FXML
    private Button adminLoginButton;
    @FXML
    private Button studentLoginButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void loginAdmin(ActionEvent event) throws IOException {
//        String email=adminEmail.getText();
//        String password=adminPassword.getText();
//        System.out.println(email );

            // URL url = getClass().getResource("/client/FXML/AdminHomeScreenFXML.fxml");

        try{
//            AnchorPane pane= FXMLLoader.load(getClass().getResource("/client/FXML/AddQuizFXML.fxml"));
//            rootPane.getChildren().setAll(pane);
            Parent root= FXMLLoader.load(getClass().getResource("/client/FXML/AdminHomeScreenFXML.fxml"));
            Stage stage=(Stage)studentPassword.getScene().getWindow();
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.setMaximized(true);
    }
        catch(Exception e){

        System.exit(0);
    }

    }

    @FXML
    private void loginStudent(ActionEvent event){
        System.out.println("helloWorld");
    }

}