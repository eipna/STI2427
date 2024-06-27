import java.util.Scanner;

public class Eliponga_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int rows = 10, columns = 4;
        int inputRows, inputColumns;
        char[][] seats = new char[rows][columns];
        boolean isNegative = false;

        for (int i = 0; i<seats.length; i++) {
            for (int j = 0; j<seats[i].length; j++) {
                seats[i][j] = '*';
            }
        }

        while (!isNegative) {
            System.out.println("\t\tBus Seat Reservation:");
            System.out.println("'*' For Open Then 'X' For Reserved Seats.");
            System.out.println("_________________________________________");
            System.out.println("\t\tCol1\tCol2\tCol3\tCol4\t|");
            for (int i = 0; i<seats.length; i++) {
                System.out.print("Row " + (i + 1) + "\t|");
                for (int j = 0; j<seats[i].length; j++) {
                    System.out.print(seats[i][j] + "\t\t");
                }
                System.out.print("|");
                System.out.println();
            }
            System.out.println("________________________________________|");
            System.out.print("Enter row and column number to reserve, separated by spaces (Enter a negative number to exit): ");
            inputRows = scanner.nextInt();
            if (inputRows < 0) {
                isNegative = true;
                System.out.println("Negative Number Detected!! Exiting Program!!");
                continue;
            }
            inputColumns = scanner.nextInt();
            if (inputRows > rows || inputColumns > columns) {
                System.out.println("Invalid Input!! Please Try Again.");
            } else if (seats[inputRows - 1][inputColumns - 1] == 'X') {
                System.out.println("Seat from Column " + inputColumns + " of Row " + inputRows + " is already reserved.");
            } else {
                seats[inputRows - 1][inputColumns - 1] = 'X';
            }
            System.out.println();
        }
    }
}