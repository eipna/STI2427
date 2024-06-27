import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);
        int FACTORIAL_RESULT = 1, NUMBER_INPUT;

        System.out.println("<----- Factorial Calculator ----->");
        for (int i=0;i<5;i++) {

            System.out.print("Enter a positive integer: ");
            NUMBER_INPUT = scannerObject.nextInt();

            if (NUMBER_INPUT < 0) {
                System.out.println("Invalid Input! Program stopped!");
                break;
            }

            for (int j=1;j<=NUMBER_INPUT;j++) {
                FACTORIAL_RESULT *= j;
            }

            System.out.print(NUMBER_INPUT + "! = ");
            for (int k=1;k<=NUMBER_INPUT;k++) {
                System.out.print(k);
                if (k < NUMBER_INPUT) {
                    System.out.print(" x ");
                }
            }

            System.out.println("\nThe FACTORIAL_RESULT of " + NUMBER_INPUT + " is: " + FACTORIAL_RESULT);
            FACTORIAL_RESULT = 1;
        }
    }
}