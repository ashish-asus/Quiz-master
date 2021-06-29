package start;

import client.models.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        createTables();
        Parent root= FXMLLoader.load(getClass().getResource("/client/FXML/loginFXML.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    private void createTables(){
        Quiz.createTable();
        Question.createTable();
        Student.createTable();
        QuizResult.createTable();
        QuizResultDetails.createTable();
    }
}


