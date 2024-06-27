package eliponga_vrixzandro_act08;

// Import scanner class for requesting user input.
import java.util.Scanner;

public class Eliponga_Vrixzandro_ACT08 {

    public static void main(String[] args) {
        // Creates an instance of the scanner class, creating a scanner object.
        Scanner scanner = new Scanner(System.in);
        
        // Request the user to enter their student number.
        System.out.print("Enter your student number: ");
        String studentNumber = scanner.nextLine();
        
        /*
        A if else statement that checks if the student number is valid or not by 
        using a regular expression that equires 4 digits in the first part then 
        a dash(-), 2 digits on the second by then a dash(-) again, and lastly 3 digits. 
        It displays the appropriate message if the student number is valid or not.
        */
        if (studentNumber.matches("[0-9]{4}-[0-9]{2}-[0-9]{3}")) {
            System.out.println("Student number is valid!");
        } else {
            System.out.println("Error: Student number is invalid.");
        }
    }
}
