import java.util.*;

public class GuessTheNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int rounds = 3;  // number of rounds

        System.out.println("===== GUESS THE NUMBER GAME =====");

        for (int round = 1; round <= rounds; round++) {

            int number = random.nextInt(100) + 1;  // 1 to 100
            int attempts = 0;
            int maxAttempts = 7;
            boolean guessed = false;

            System.out.println("\nRound " + round);
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number.");
                    guessed = true;

                    // Scoring (more points for fewer attempts)
                    int points = (maxAttempts - attempts + 1) * 10;
                    totalScore += points;

                    System.out.println("You earned " + points + " points.");
                    break;
                } 
                else if (guess < number) {
                    System.out.println("Too low!");
                } 
                else {
                    System.out.println("Too high!");
                }
            }

            if (!guessed) {
                System.out.println("Out of attempts! The number was: " + number);
            }
        }

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Your Total Score: " + totalScore);
        sc.close();
    }
}