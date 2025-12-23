package quizz_app;
import java.sql.*;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

class QuizCreate {
    String queryGetLastId =  "SELECT id FROM quizzes WHERE id=(SELECT max(id) FROM quizzes);";
    String insertQuestion = "INSERT INTO questions(text, correct_answer_index, quiz_id) VALUES (?, ?, ?);";//string int int
    String addOption = "INSERT INTO options(question_id,option_text, option_index) VALUES(?, ?, ?);";//int string int
    String newQuiz = "INSERT INTO quizzes(title, description) VALUES (?, ?);";//string string
    Scanner myObj = new Scanner(System.in);
    private Connection con;

    QuizCreate(String url, String user, String password) throws SQLException{
        this.con = DriverManager.getConnection(url, user, password);
    }
    
    int getLastId() throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(queryGetLastId);
        rs.next();
        int id = rs.getInt("id");
        return id;
    }
    
    void create() throws SQLException {
        //create quiz
        PreparedStatement nq = con.prepareStatement(
            newQuiz,
            Statement.RETURN_GENERATED_KEYS//ask what does this mean
        );

        System.out.print("Enter name for a new quiz: \n");
        String titleForQuiz = myObj.nextLine();
        System.out.print("Enter description for new quiz:\n");
        String descriptionForQuiz = myObj.nextLine();


        nq.setString(1, titleForQuiz);
        nq.setString(2, descriptionForQuiz);
        nq.executeUpdate();


        ResultSet quizKeys = nq.getGeneratedKeys();
        quizKeys.next();
        int quizId = quizKeys.getInt(1);
  
        while(true) {
            

            System.out.print("Enter new question: \n");
            String newQuestion = myObj.nextLine();

            if(newQuestion.isEmpty()) {
                break;
            }

            System.out.print("What is the correct answer index?: \n");
            String correctAnswer = myObj.nextLine();

            PreparedStatement questionPs = con.prepareStatement(
                insertQuestion,
                Statement.RETURN_GENERATED_KEYS
            );

            questionPs.setString(1, newQuestion);
            questionPs.setInt(2, Integer.parseInt(correctAnswer));
            questionPs.setInt(3, quizId);
            questionPs.executeUpdate();

            ResultSet questionKeys = questionPs.getGeneratedKeys();
            questionKeys.next();
            int questionId = questionKeys.getInt(1);
            
            
            int optionIndex = 0;
            
            while(true) {
                System.out.print("Insert new option: \n");
                String newOption = myObj.nextLine();

                if(newOption.isEmpty()) {
                    break;
                }


                PreparedStatement newPreparedStatement = con.prepareStatement(addOption);
                newPreparedStatement.setInt(1, questionId);
                newPreparedStatement.setString(2, newOption);
                newPreparedStatement.setInt(3, optionIndex++);
                int execute = newPreparedStatement.executeUpdate();
            
            }
            
        }
        
    }
    
    
}
