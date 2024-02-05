import java.util.*;

public class numbergame {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int score = 0;
        
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Can you please enter your name: ");
        String name=sc.next();
        System.out.println("Thank you "+name+".");
        System.out.println("You have to guess a number between 1 to 100");
        System.out.println("Also, you have to guess the correct number in 5 chances only");

        boolean playAgain = true;
        while (playAgain) {
            int attempts = 0; 

            int randomNumber = random.nextInt(max - min + 1) + min;
            boolean guessedCorrectly = false;

            while (!guessedCorrectly && attempts < 5) {
                System.out.print("Enter your guessed number: ");
                int number = sc.nextInt();
                attempts++;

                if (number == randomNumber) {
                    System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                } else if (number < randomNumber) {
                    System.out.println("Your number is less than the winning number");
                } else {
                    System.out.println("Your number is more than the winning number");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You have reached the maximum number of attempts. The correct number was: " + randomNumber);
            }

            System.out.print("Do you want to play the game again? (Yes/No): ");
            String again = sc.next();
            playAgain = again.equals("Yes");
        }

        System.out.println("Thanks " +name+"! Your total score is: " + score);
        sc.close();
    }
}
