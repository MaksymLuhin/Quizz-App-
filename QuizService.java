package quizz_app;

class QuizService {
    boolean isCorrect(Question question, int answer) {
        if(question.getCorrectAnswer() == answer) {
            return true;
        }
        else {
            return false;
        }
    }

    boolean isFinished(QuizSession session) {
        if(session.getCurrentIndex() > session.getCurrentQuiz().getLength()-1) {
            return true;
        }
        else {
            return false;
        }
    }

    Question getCurrentQuestion(QuizSession session) {
        return session.getCurrentQuiz().getQuestion(session.getCurrentIndex());
    }
    
}
