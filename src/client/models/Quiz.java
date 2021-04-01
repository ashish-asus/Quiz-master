package client.models;

import client.constants.DatabaseConstants;
import java.sql.*;
import java.util.*;

public class Quiz {
    // Properties

    private Integer quizId;
    private String title;

    // Constructers
    public Quiz(String title) {
        this.title = title;
    }

    public static class MetaData {

        public static final String TABLE_NAME = "QUIZZES";
        public static final String QUIZ_ID = "ID";
        static final String TITLe = "TITLE";

    }

    public Quiz() {
    }

    // Getter Setters
    public Integer getQuizId() {
        return quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    // Other Methods
    public static void createTable() {
        try {
            String raw = "CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT, %s VARCHAR(50) );";
            String query = String.format(raw, MetaData.TABLE_NAME, MetaData.QUIZ_ID, MetaData.TITLe);
            System.err.println(query);
            String connectionUrl = DatabaseConstants.CONNECTION_URL;
            Class.forName(DatabaseConstants.DRIVER_CLASS);
            Connection connection = DriverManager.getConnection(connectionUrl);
            PreparedStatement ps = connection.prepareStatement(query);
            boolean b = ps.execute();
            System.out.println("models.Quiz.createTable()");
            System.out.println(b);
            connection.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int save() {
        String raw = "Insert into %s (%s) values (?)";
        String query = String.format(raw, MetaData.TABLE_NAME, MetaData.TITLe);
        String connectionUrl = DatabaseConstants.CONNECTION_URL;

        try {
            Class.forName(DatabaseConstants.DRIVER_CLASS);
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {

                PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, this.title);
                int i = ps.executeUpdate();
                ResultSet keys = ps.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }

        return -1;
    }

    public boolean save(List<Question> questions) {
        boolean flag = true;
        this.quizId = this.save();

        for (Question q : questions) {
            flag = flag && q.save();
            System.out.println(flag);
        }
        return flag;
    }




}