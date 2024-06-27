import java.util.Scanner;

public class GrossPayCalculator {
    public static void main(String[] args) {
        Scanner scannerObject = new Scanner(System.in);

        double RatePerHour, GrossPay, BasicPay, OvertimePay;
        int NumberOfHoursWorked, NumberOfOvertime;
        String EmployeeName;
        char choice;

        System.out.println("<----- Gross Pay Calculator ----->");
        System.out.print("Enter employee name: ");
        EmployeeName = scannerObject.nextLine();
        System.out.print("Press 'F' for Full Time or 'P' for Part Time: ");
        choice = scannerObject.next().charAt(0);

        switch (choice) {
            case 'F':
                System.out.println("----------- Full Time Employee -----------");
                System.out.print("Enter Basic Pay: ");
                BasicPay = scannerObject.nextDouble();

                GrossPay = BasicPay;

                System.out.println("------------------------------------------");
                System.out.println("Employee Name:          " + EmployeeName);
                System.out.println("Basic Pay:              " + BasicPay);
                System.out.println("------------------------------------------");
                System.out.println("Gross Pay:              " + GrossPay);
                break;
            case 'P':
                System.out.println("----------- Part Time Employee -----------");
                System.out.print("Enter rate per hour: ");
                RatePerHour = scannerObject.nextDouble();
                System.out.print("Enter number of hours worked: ");
                NumberOfHoursWorked = scannerObject.nextInt();
                System.out.print("Enter number of overtime: ");
                NumberOfOvertime = scannerObject.nextInt();

                BasicPay = RatePerHour * NumberOfHoursWorked;
                OvertimePay = NumberOfOvertime * (RatePerHour * 1.25);
                GrossPay = BasicPay + OvertimePay;

                System.out.println("------------------------------------------");
                System.out.println("Employee Name:          " + EmployeeName);
                System.out.println("Basic Pay:              " + BasicPay);
                System.out.println("Overtime Pay:           " + OvertimePay);
                System.out.println("------------------------------------------");
                System.out.println("Gross Pay:              " + GrossPay);
                break;
            default:
                System.out.println("Error: Invalid Input!");
        }
    }
}