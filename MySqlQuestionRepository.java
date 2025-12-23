package quizz_app;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

interface QuestionRepository{
    List<Question> findByQuizId(int quizId) throws SQLException;
}

class MySqlQuestionRepository implements QuestionRepository{
    
    private final String url;
    private final String user;
    private final String password;

    MySqlQuestionRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }
    
    @Override
    public List<Question> findByQuizId(int quizId) throws SQLException {
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection Established successfully");
        
        List<Question> questions = new ArrayList<>();
        String queryQuestion = "SELECT * FROM questions WHERE quiz_id = ?";


        PreparedStatement st = con.prepareStatement(queryQuestion);
        st.setInt(1, quizId);
        ResultSet rs = st.executeQuery();
        

        while(rs.next()) {

            String question = rs.getString("text");
            int correctAnswer = rs.getInt("correct_answer_index");
            int questionId = rs.getInt("id");
            List<String> options = loadOptions(con, questionId);

            questions.add(new Question(question, options, correctAnswer));
            
        }

        st.close();
        con.close();
        System.out.print("Connection closed...\n");
        return questions;
    }

    private List<String> loadOptions(Connection con, int question_id) throws SQLException {
        List<String> result = new ArrayList<>();
        String query = "SELECT option_text FROM options WHERE question_id = ? ORDER BY option_index";


        PreparedStatement st = con.prepareStatement(query);
        st.setInt(1, question_id);
        
        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            result.add(rs.getString("option_text"));
        }

        return result;
    }
}
