import java.util.*;

public class QuizApp {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;

    public QuizApp(List<Question> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public void startQuiz() {
        if (currentQuestionIndex < questions.size()) {
            Question question = questions.get(currentQuestionIndex);
            System.out.println(question.getQuestion());
            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }
            startTimer();
            getUserInput();
        } else {
            showResult();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            int count = 10; 

           
            public void run() {
                count--;
                System.out.println("Time Left: " + count+ " secs");
                if (count == 0) {
                    timer.cancel();
                    System.out.println("Time's up!");
                    startQuiz();
                }
            }
        }, 0, 1000); }

    private void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        timer.cancel(); 
        checkAnswer(userChoice);
        scanner.close();
    }

    private void checkAnswer(int userChoice) {
        Question question = questions.get(currentQuestionIndex);
        if (userChoice == question.getCorrectAnswer()) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
        currentQuestionIndex++;
        startQuiz();
    }

    private void showResult() {
        System.out.println("Quiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
    List<Question> questions = new ArrayList<>();
    
    // Add your questions here
    List<String> options1 = Arrays.asList("London", "Delhi", "Berlin", "Rome");
    questions.add(new Question("What is the capital of India?", options1, 2));
    List<String> options2 = Arrays.asList("Delhi", "Agra", "Mohali", "Pune");
    questions.add(new Question("Where is Taj Mahal situated", options2, 2));
    List<String> options3 = Arrays.asList("29", "27", "28", "31");
    questions.add(new Question("How many states in India?", options3, 1));
    List<String> options4 = Arrays.asList("President", "Prime Minister", "Defence Minister", "Home Minister");
    questions.add(new Question("Who is called as the first person in India", options4, 1));
    List<String> options5 = Arrays.asList("Moga", "Sangrur", "Chandigarh", "Mohali");
    questions.add(new Question("What is capital of Punjab", options5, 3));
    
    // Add more questions...
    
    QuizApp quizApp = new QuizApp(questions);
    quizApp.startQuiz();
    
}

}

class Question {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
