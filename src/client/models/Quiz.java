package client.models;

import java.sql.*;

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
           connection.close();
           System.out.println(b);


        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public int save(){

            String raw="Insert into %s(%s) values (?) ";
            String query=String.format(raw,MetaData.TABLE_NAME,MetaData.TITLE);
            String connectionUrl = "jdbc:sqlite:quiz.db";
            try{
                Class.forName("org.sqlite.JDBC");
            try(Connection connection=DriverManager.getConnection(connectionUrl) ) {

                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, this.title);
                int i = ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }


            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return -1;

    }


}
