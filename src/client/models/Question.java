package client.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Question {
    Quiz quiz;
    Integer questionId;
    String question;
    String option1;
    String option2;
    String option3;
    String option4;
    String answer;

    public static class MetaData{
        public static final String TABLE_NAME="questions";
        public static final String OPTION1="option1";
        public static final String OPTION2="option2";
        public static final String OPTION3="option3";
        public static final String OPTION4="option4";
        public static final String ANSWER="answer";
        public static final String QUIZ_ID="quiz_id";
        public static final String TITLE="title";

    }
    public Question() {
    }

    public Question(Quiz quiz, String question, String option1, String option2, String option3, String option4, String answer) {
        this.quiz = quiz;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getAnswer() {
        return answer;
    }
    public static void createTable(){
        try {
            String raw="CREATE TABLE %s ( id INTEGER PRIMARY KEY AUTOINCREMENT, question VARCHAR(1000), " +
                    "%s VARCHAR(500) ," +
                    "%s VARCHAR(500) ," +
                    "%s VARCHAR(500) ," +
                    "%s VARCHAR(500) ," +
                    "%s VARCHAR(500) ," +
                    "%s INTEGER," +
                    "FOREIGN KEY (%s) REFERENCES %s(%s) )";
            String query=String.format(raw,
                    MetaData.TABLE_NAME,
                    MetaData.OPTION1,
                    MetaData.OPTION2,
                    MetaData.OPTION3,
                    MetaData.OPTION4,
                    MetaData.ANSWER,
                    MetaData.QUIZ_ID,
                    MetaData.QUIZ_ID,
                    MetaData.TABLE_NAME,
                    MetaData.QUIZ_ID);
            System.out.println(query);
            String connectionUrl = "jdbc:sqlite:quiz.db";
            Class.forName("org.sqlite.JDBC");
            Connection connection= DriverManager.getConnection(connectionUrl);
            PreparedStatement ps=connection.prepareStatement(query);
            boolean b= ps.execute();
            System.out.println(b);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
