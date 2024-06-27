import java.util.Scanner; // For creating a scanner object for receiving user inputs

public class LabExer5B {
    // Static array of Strings to store 10 questions
    static String[] questions = {
            "What is the smallest planet in our solar system?",
            "What is the rarest blood type?",
            "How many sides does a hexagon have?",
            "What is the closest planet to the Sun?",
            "What is the tallest mammal?",
            "What is the largest ocean on Earth?",
            "What is the symbol for Potassium on the periodic table?",
            "How many continents are there in the world?",
            "What is the hardest natural substance on Earth?",
            "How many players are on a baseball team?"
    };

    // Static 2D array of Strings to store choices for the 10 questions
    static String[][] choices = {
            {"A. Pluto", "B. Earth", "C. Mercury"},
            {"A. AB Negative", "B. O Positive", "C. B+"},
            {"A. 5", "B. 9", "C. 6"},
            {"A. Mercury", "B. Uranus", "C. Mars"},
            {"A. Giraffe", "B. Blue Whale", "C. Elephant"},
            {"A. Pacific Ocean", "B. Atlantic Ocean", "C. Indian Ocean"},
            {"A. K", "B. C", "C. H"},
            {"A. 4", "B, 9", "C. 7"},
            {"A. Diamond", "B. Gold", "C. Platinum"},
            {"A. 7", "B. 9", "C. 12"}
    };

    // Static array of Strings to store the correct answers for each question
    static String[] correctAnswers = {
            "C", "A", "A", "A", "A", "A", "A", "C", "A", "B"
    };

    public static void main(String[] args) {
        // Initializes a scanner object
        Scanner scanner = new Scanner(System.in);

        // Initializes an integer called points to store the user's points
        int points = 0;

        // Initializes a constant integer called quizSize and sets it to 10
        final int quizSize = 10;

        System.out.println("10 Questions Quiz Bee");

        /*
        For loop that displays the question, choices and prompts the user to answer
        in a loop that depends on the number of questions.
         */
        for (int i = 0; i<quizSize; i++) {
            System.out.println((i + 1) + ". " + questions[i]);
            for (int j = 0; j< choices[i].length; j++) {
                System.out.println(choices[i][j]);
            }

            // Declares a String variable called answer to store the user's guess
            String answer;

            /*
            Infinite do while loop to revert guess if exceptions occur
            and will only break if no exceptions occur.
             */
            do {
                // Prompts the user to enter answer (Can only be A, B or C)
                System.out.print("Enter your answer (A, B, C): ");
                answer = scanner.nextLine();

                try {
                    if (answer.isEmpty()) {
                        // If user input is blank, will throw a BlankAnswerException
                        throw new BlankAnswerException();
                    } else if (containsNumbers(answer)) {
                        // If user input is a number, will throw a NumericAnswerException
                        throw new NumericAnswerException();
                    } else if (containsSpecialCharacters(answer)) {
                        // If user input is a special character, will throw a CharacterAnswerException
                        throw new CharacterAnswerException();
                    } else if (!isValidAnswer(answer)) {
                        // If user input is not A, B or C, will throw a NotValidAnswerException
                        throw new NotValidAnswerException();
                    }
                } catch (BlankAnswerException | NotValidAnswerException | NumericAnswerException | CharacterAnswerException e) {
                    // Prints out the exceptions for each corresponding exception
                    System.out.println(e.getMessage());

                    // Will revert back to the start of the loop
                    continue;
                }
                break;
            } while (true);

            // If the answer is correct, it will say correct and will increment a point
            if (answer.equalsIgnoreCase(correctAnswers[i])) {
                System.out.println("Your answer is correct!!");
                points++;
            // If the answer is wrong, it will say wrong and will not increment a point
            } else {
                System.out.println("Your answer is wrong");
            }
        }

        // Once all questions are answered, it will display the total number of correct answers
        System.out.println("Your score is " + points + " / " + quizSize);
    }

    /*
    Static boolean return type function
    that checks if the user's input
    is A, B or C.
     */
    static boolean isValidAnswer(String answer) {
        return answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") || answer.equalsIgnoreCase("C");
    }

    /*
    Static boolean return type function that will
    return true if the user input is a number
    and false if it does not.
     */
    static boolean containsNumbers(String answer) {
        try {
            Integer.parseInt(answer);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    /*
    Static boolean return type function that will return true
    if the user's input matches with any special character
    and will return false if it does not.
     */
    static boolean containsSpecialCharacters(String answer) {
        String specialChars = "!@\\#$%^&*()_+-=[]{}|;':,./<>?";
        char placeHolder = answer.charAt(0);
        for (int i = 0; i<specialChars.length(); i++) {
            char character = specialChars.charAt(i);
            if (placeHolder == character) {
                return true;
            }
        }
        return false;
    }
}