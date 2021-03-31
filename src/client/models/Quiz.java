package client.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Quiz {
    private Integer quizId;
    private String title;

    public String getTitle() {
        return title;
    }

    public Quiz(String title) {
        this.title = title;
    }

    public Quiz() {
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizId=" + quizId +
                ", title='" + title + '\'' +
                '}';
    }

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }
public static class MetaData{
    public static final String TABLE_NAME="quiz";
    public static final String QUIZ_ID="quiz_id";
    public static final String TITLE="title";
}
    public static  void  createTable(){
        try {
            String raw= "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50) );";
            String query = String.format(raw,MetaData.TABLE_NAME,MetaData.QUIZ_ID,MetaData.TITLE);
            System.out.println(query);
            String connectionUrl = "jdbc:sqlite:quiz.db";
            Class.forName("org.sqlite.JDBC");
            Connection connection=DriverManager.getConnection(connectionUrl);
            PreparedStatement ps=connection.prepareStatement(query);
           boolean b= ps.execute();
           System.out.println(b);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
