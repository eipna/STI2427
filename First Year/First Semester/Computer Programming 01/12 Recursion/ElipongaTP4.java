import java.util.Scanner;

public class Eliponga_TP4 {

    static Scanner scanner = new Scanner(System.in);
    static String answer;
    static int myScore = 0, Index = 0;

    static String[] listOfQuestions = {
        "Who is the author of 'The Angel Next Door Spoils Me Rotten?'",
        "What is the genre of 'The Angel Next Door Spoils Me Rotten?'",
        "Who is the main female protagonist in 'The Angel Next Door Spoils Me Rotten?'",
        "What is the nickname given to Mahiru Shiina at school?",
        "How many volumes of the light novel series released as of 2023?"
    };

    static String[][] listOfChoices = {
        {"A. Hazano Kazutake", "B. Saekisan", "C. Wan Shibata"},
        {"A. Action and Adventure", "B. Romantic comedy, slice of life", "C. Horror and Thriller"},
        {"A. Amane Fujimiya", "B. Mahiru Shiina", "C. Suzu Yuki"},
        {"A. The Angel", "B. The Demon", "C. The Goddess"},
        {"A. 5 volumes", "B. 8 volumes", "C. 10 volumes"}
    };

    static String[] listOfCorrectAnswers = {"A", "B", "A", "A", "B"};

    static void askQuestions() {
        if (Index < listOfQuestions.length) {
            System.out.println((Index + 1) + "). " + listOfQuestions[Index]);
            for (String s : listOfChoices[Index]) {
                System.out.println(s);
            }

            System.out.print("Choose your answer: ");
            answer = scanner.next().toUpperCase();

            if (answer.equalsIgnoreCase(listOfCorrectAnswers[Index])) {
                System.out.println("Your answer is correct!!");
                myScore++;
            } else {
                System.out.println("Your answer is incorrect!!");
            }
        }
        System.out.println();
        Index++;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to a quiz bee (The Angel Next Door Spoils Me Rotten)");
        
        while (Index != listOfQuestions.length) {
            askQuestions();
        }
        
        if (myScore == listOfQuestions.length) {
            System.out.println("Congrats!! You got a perfect score!!");
        } else if (myScore < 5 && myScore > 0) {
            System.out.println("Your score is " + myScore + " over 5.");
        } else {
            System.out.println("You got a score of 0, better luck next time.");
        }
    }
}