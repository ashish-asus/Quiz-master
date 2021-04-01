package client.models;

public class test {
    public static void main(String[] args) {
        Quiz quiz =new Quiz("helloQuiz");
        quiz.setQuizId(quiz.save());
        Question question=new Question(quiz,"1+1=","2","10","43","32","2");
        question.save();
    }
}
