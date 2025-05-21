import java.util.Scanner;
class Question {
    private String text;
    private String answer;
    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }
    public String getText() {
        return text;
    }
    public boolean checkAnswer(String response) {
        return answer.equalsIgnoreCase(response.trim());
    }
}
class Quiz {
    private Question[] questions;
    private int count;
    public Quiz() {
        questions = new Question[25]; // max 25
        count = 0;
    }
    public void add(Question q) {
        if (count < 25) {
            questions[count] = q;
            count++;
        } else {
            System.out.println("Quiz is full. Cannot add more questions.");
        }
    }
    public void giveQuiz() {
        Scanner sc = new Scanner(System.in);
        int score = 0;

        for (int i = 0; i < count; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i].getText());
            System.out.print("Your answer: ");
            String userAnswer = sc.nextLine();
            if (questions[i].checkAnswer(userAnswer)) {
                System.out.println("Dammmmn slayin");
                score++;
            } else {
                System.out.println("you lost aura");
            }
            System.out.println();
        }
        System.out.println("Done testing ya");
        System.out.println("You got"+score+ "out of" +count+"correct.");
    }
}
public class QuizTime {
    public static void main(String[] args) {
        Quiz myQuiz = new Quiz();

        myQuiz.add(new Question("Which animal can't jump? (chonky legend)", "Elephant"));
        myQuiz.add(new Question("Which gas do humans need to survive? (not vibes)", "Oxygen"));
        myQuiz.add(new Question("Which country invented pizza? (bless them)", "Italy"));
        myQuiz.add(new Question("What does 'LOL' stand for? (not lots of love)", "Laugh Out Loud"));
        myQuiz.add(new Question("Which fruit is also a tech company?", "Apple"));
        myQuiz.add(new Question("What's the fear of long words called? (ironically long)", "Hippopotomonstrosesquipedaliophobia"));

        myQuiz.giveQuiz();
    }
}
