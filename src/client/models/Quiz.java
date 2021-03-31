package client.models;

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

    public static  void  createTable(){
        String query="CREATE TABLE quiz ( id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(50) );";
    }
}
