package quizz_app;
import java.util.List;

class Question {
    private final String text;
    private final List<String> options;
    private final int correctAnswer;
    
    Question(String text, List<String> options, int correctAnswer) {
        if(text == null) {
            throw new IllegalArgumentException("Text cant be null");
        }
        if(options == null || options.size() < 2) {
            throw new IllegalArgumentException("At least two options are required");
        }
        if(correctAnswer < 0 || correctAnswer >= options.size()) {
            throw new IllegalArgumentException("Correct answer index out of range");
        }

        this.text = text;
        this.options = List.copyOf(options);
        this.correctAnswer = correctAnswer;
    }

    String getText() {
        return text;
    }

    List<String> getOptions() {
        return options;
    }

    int getCorrectAnswer() {
        return correctAnswer;
    }
}
