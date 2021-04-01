package client.controllers;

import client.models.Question;
import client.models.Quiz;
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
import java.util.*;

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

    private Quiz quiz;
    private ArrayList<Question> questions=new ArrayList<>();
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
    private boolean validateFields(){


        if(quiz ==null){
            Notifications.create()
                    .title("Quiz").position(Pos.CENTER)
                    .darkStyle().text("Please Enter Quiz Title")
                    .showError();
            return false;
        }

        String qu = this.question.getText();
        String op1 = this.option1.getText();
        String op2 = this.option2.getText();
        String op3 = this.option3.getText();
        String op4 = this.option4.getText();
        Toggle selectedRadio = radioGroup.getSelectedToggle();
        System.out.println(selectedRadio);
        if(qu.trim().isEmpty() ||
                op1.trim().isEmpty() ||
                op2.trim().isEmpty() || op3.trim().isEmpty()
                || op4.trim().isEmpty()){

            Notifications.create()
                    .title("Question").position(Pos.CENTER)
                    .darkStyle().text("All Fields Are Required.... \n [Question , Option1 , Option 2 , Option 3 , Option 4]")
                    .showError();
            return false;



        }else{
            if(selectedRadio == null){
                Notifications.create()
                        .title("Question").position(Pos.CENTER)
                        .darkStyle().text("Please Select A Answer....")
                        .showError();
                return false;
            }else{
                return true;   // save Quistion and add next
            }
        }
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
            this.quiz=new Quiz(title);
        }
    }
    private boolean addQuestions(){
        boolean valid = validateFields();
        Question question = new Question();
        if(valid){
            //save
            question.setOption1(option1.getText().trim());
            question.setOption2(option2.getText().trim());
            question.setOption3(option3.getText().trim());
            question.setOption4(option4.getText().trim());
            Toggle selected = radioGroup.getSelectedToggle();
            String ans = null;
            if(selected == option1radio){
                ans = option1.getText().trim();
            }else if(selected == option2radio){
                ans = option2.getText().trim();
            }
            else if(selected == option3radio){
                ans = option3.getText().trim();
            }
            else if(selected == option4radio){
                ans = option4.getText().trim();
            }
            question.setAnswer(ans);
            question.setQuestion(this.question.getText().trim());

            this.question.clear();
            option1.clear();
            option2.clear();
            option3.clear();
            option4.clear();
            questions.add(question);
            question.setQuiz(quiz);
            System.out.println("Save Question...");
            System.out.println(questions);
            System.out.println(quiz);
        }
        quizTitle.clear();
        return valid;
    }


    @FXML
    private void submitQuiz(ActionEvent event) {
        boolean flag = addQuestions();
        if(flag){
            flag = quiz.save(questions);
            if(flag){
                // success
                this.quizTitle.setDisable(false);
                Notifications.create()
                        .title("Success").position(Pos.CENTER)
                        .darkStyle().text("Quiz Successfully Saved...")
                        .showInformation();

            }else{

                Notifications.create()
                        .title("Fail..").position(Pos.CENTER)
                        .darkStyle().text("cant Save Quiz.. Try Again..")
                        .showError();
            }
        }
    }



    @FXML
    private void addNextQuestion(ActionEvent event) {
        addQuestions();
    }












}
