import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I've chosen a number between " + minRange + " and " + maxRange + ". Try to guess it!");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;

            if (userGuess == randomNumber) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly.");
                System.out.println("It took you " + attempts + " attempts.");
            } else if (userGuess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
    }
}

