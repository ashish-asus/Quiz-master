package client.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class AddQuizFXMLController implements Initializable {
    @FXML
    public JFXTextField quizTitle;
    @FXML
    public JFXTextArea question;
    @FXML
    public JFXTextField option1;
    @FXML
    public JFXTextField option2;
    @FXML
    public JFXTextField option3;
    @FXML
    public JFXTextField option4;
    @FXML
    public JFXRadioButton option1radio;
    @FXML
    public JFXRadioButton option2radio;
    @FXML
    public JFXRadioButton option3radio;
    @FXML
    public JFXRadioButton option4radio;
    @FXML
    public JFXButton addNextQuestion;
    @FXML
    public JFXButton submitQuiz;

    public ToggleGroup radioGroup;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        radioButtonGroup();
    }
    public void radioButtonGroup(){
        radioGroup=new ToggleGroup();
        option1radio.setToggleGroup(radioGroup);
        option2radio.setToggleGroup(radioGroup);
        option3radio.setToggleGroup(radioGroup);
        option4radio.setToggleGroup(radioGroup);

    }
}
