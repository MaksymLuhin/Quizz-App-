package quizz_app;
import java.util.List;

class Quiz {
    private final List<Question> questions;
    
    Quiz(List<Question> questions) {
        this.questions = questions;
    }

    int getLength() {
        return questions.size();
    }

    Question getQuestion(int index) {
        if (index < 0 || index >= questions.size()) {
            throw new IndexOutOfBoundsException("Invalid question index");
        }
        return questions.get(index);
    }

    List<Question> getQuestions() {
        return questions;
    } 
}
