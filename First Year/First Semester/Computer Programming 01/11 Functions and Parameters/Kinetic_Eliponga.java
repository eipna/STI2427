package kinetic_eliponga;

import java.util.Scanner;

public class Kinetic_Eliponga {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double mass;
        double velocity;
        
        System.out.print("Enter mass in kilograms: ");
        mass = scanner.nextInt();
        System.out.print("Enter velocity in meters per second: ");
        velocity = scanner.nextDouble();
        
        System.out.printf("The object's kinetic energy is: %.2f", CalculateKE(mass, velocity));
        System.out.print(" J.");
    }
    
    public static double CalculateKE(double m, double v) {
        return (m / 2) * Math.pow(v, 2);
    }
    
}