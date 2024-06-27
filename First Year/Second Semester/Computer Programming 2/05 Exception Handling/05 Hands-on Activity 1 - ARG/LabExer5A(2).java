import java.util.InputMismatchException; // For the InputMismatchException
import java.util.Scanner; // For creating a scanner object for receiving user input
import java.util.Random; // For creating a random object for generating random numbers

public class LabExer5A {
    public static void main(String[] args) {
        // Creates a scanner object from the Scanner class
        Scanner scanner = new Scanner(System.in);

        // Creates a random object from the Random class
        Random random = new Random();

        /*
        Initializes variable that stores the total number of guesses,
        random number that the user has to guess and the user's guess.
         */
        int totalNumberOfGuesses = 0;
        int randomNumber = random.nextInt(50) + 1;
        int guess;

        System.out.println("Guess a number from 1 to 50!");

        do {
            try {
                // Prompts the user to guess a number from 1 to 50
                System.out.print("Enter guess: ");

                // Can throw a InputMismatchException if the input is not a number
                guess = scanner.nextInt();

                if (guess < 1 || guess > 50) {
                    // If the user's guess is lower than 1 or higher than 50 it will throw an exception
                    throw new GuessNotInRangeException();
                }

                // If user's guess is higher than the random number, it will say that it is too high
                if (guess > randomNumber) {
                    System.out.println("Too high. Try again.");

                    // Increments 1 to number of attempts
                    totalNumberOfGuesses++;
                } else if (guess == randomNumber) {

                    // Increments 1 to number of attempts
                    totalNumberOfGuesses++;

                    /*
                    If the user's guess matches with the random number
                    it will break from the loop and will display
                    the total number of attempts the user made
                    and finally ending the program.
                     */
                    System.out.println("You got it in " + totalNumberOfGuesses + " attempt(s)!");
                    break;
                } else {

                    // If the user's guess is lower than the random number, it will say that guess is too low
                    System.out.println("Too low. Try again.");

                    // Increments 1 to number of attempts
                    totalNumberOfGuesses++;
                }
            } catch (InputMismatchException ime) {
                // If the user's input is not a number, it will throw a InputMismatchException
                System.out.println("Guess can only be numbers");

                // Consume the remaining newline character
                scanner.nextLine();
            } catch (GuessNotInRangeException gnire) {
                // Catches the GuessNotInRangeException
                System.out.println(gnire.getMessage());

                // Consume the remaining newline character
                scanner.nextLine();
            }
        } while (true); // Creates an infinite loop
    }
}