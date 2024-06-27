package elipongatp6;

import java.util.Scanner;

public class ElipongaTP6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numberMales, numberFemales, totalStudents;
        double percentMales, percentFemales;
        
        System.out.print("Enter the number of males: ");
        numberMales = input.nextInt();
        System.out.print("Enter the number of females: ");
        numberFemales = input.nextInt();
        
        totalStudents = numberMales + numberFemales;
        percentMales = ((double)numberMales / totalStudents) * 100;
        percentFemales = ((double)numberFemales / totalStudents) * 100;
        
        System.out.println("Number of students = " + totalStudents);
        System.out.printf("Male = %.2f", percentMales);
        System.out.print("%\n");
        System.out.printf("Female = %.2f", percentFemales);
        System.out.print("%\n");
    }
}