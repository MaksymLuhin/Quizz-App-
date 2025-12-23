package quizz_app;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException  {
        String url =
    "jdbc:mysql://127.0.0.1:3306/QuizApp?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String username = "root";
        String password = "1234";

        MySqlQuestionRepository newRep = new MySqlQuestionRepository(url, username, password);
        Quiz quiz1 = new Quiz(newRep.findByQuizId(1));
        QuizSession newSession = new QuizSession(quiz1);
        newSession.start();
    //    QuizCreate newQuiz = new QuizCreate(url, username, password);
    //     newQuiz.create();
        
     }
};