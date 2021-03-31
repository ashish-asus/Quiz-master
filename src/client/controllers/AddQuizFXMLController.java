package client.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.management.Notification;
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
    @FXML
    public ToggleGroup radioGroup;
    @FXML
    public JFXButton setQuizTitleButton;

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

    public void setQuizTitle(ActionEvent event) {
        String title=quizTitle.getText();
        if(title.trim().isEmpty()){
            Notifications notifications = Notifications.create();
            notifications.text("Enter valid Quiz Title");
            notifications.title("Quiz Title");
            notifications.position(Pos.TOP_RIGHT);
            notifications.hideAfter(Duration.millis(2000));
            notifications.showError();
        }
        else{
            quizTitle.setEditable(false);
        }
    }

    public void submitQuiz(ActionEvent event) {


    }

    public void addNextQuestion(ActionEvent event) {
        String qu=this.question.getText();
        String op1=this.option1.getText();
        String op2=this.option2.getText();
        String op3=this.option3.getText();
        String op4=this.option4.getText();
        Toggle selectedRadio=radioGroup.getSelectedToggle();

        if(qu.trim().isEmpty() || op1.trim().isEmpty() || op2.trim().isEmpty() || op3.trim().isEmpty() || op4.trim().isEmpty() || selectedRadio==null){

            Notifications.create()
                    .title("Question")
                    .darkStyle()
                    .text("All Fields Are Required (Question,options,Answer)")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.millis(2000))
                    .showError();
        }


    }
}
