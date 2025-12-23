package quizz_app;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class QuizSession {
    private final Quiz quiz;
    private final QuizService quizService;
    private int score;
    private int currentIndex;
    Map<String, Integer> m = new HashMap<>();
    //map outputs
    

    QuizSession(Quiz quiz) {
        this.quiz = quiz;
        this.quizService = new QuizService();
        this.score = 0;
        this.currentIndex = 0;
        
    }

    void createMap() {
        m.put("A", 0);
        m .put("B", 1);
        m.put("C", 2);
        m.put("D", 3);
    }


    void start() {

        //initialse map
        createMap();
        Scanner myObj = new Scanner(System.in);
        System.out.print("Give answer with letters A/B/C/D");
        while(!quizService.isFinished(this)) {
            System.out.printf("%s\n", quiz.getQuestion(currentIndex).getText());
            for(String item: quiz.getQuestion(currentIndex).getOptions()) {
                System.out.print(item + "\n");
            }
            String answer = myObj.nextLine();
            if(quizService.isCorrect(quiz.getQuestion(currentIndex), m.get(answer))) {
                score++;
                System.out.printf("Correct! Your current score is: %d\n", score);
            }
            else {
                System.out.printf("Incorrect( Your score is: %d\n", score);
                score--;
            }
            currentIndex++;
        }

        System.out.print("Quiz finished");
    }

    void answerQuestion(int answer) {
        if (quizService.isCorrect(quiz.getQuestion(currentIndex), answer)) {
            score+=1;
        }
        else {
            score-=1;
        }
    }

    int getScore() {
        return score;
    }

    int getCurrentIndex() {
        return currentIndex;
    }

    Quiz getCurrentQuiz() {
        return quiz;
    }
}