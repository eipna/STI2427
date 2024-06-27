package elipongalab6;

import java.util.Scanner;

public class ElipongaLab6 {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int Level;
        double bonusAttackSpeed, currentAttackSpeed, baseAttackSpeed;
        
        System.out.print("Enter the base attack speed: ");
        baseAttackSpeed = input.nextDouble();
        System.out.print("Enter the bonus attack speed %: ");
        bonusAttackSpeed = input.nextDouble();
        System.out.print("Enter the level: ");
        Level = input.nextInt();
        
        bonusAttackSpeed/=100;
        currentAttackSpeed = baseAttackSpeed * (1 + (bonusAttackSpeed * (Level - 1)));
        System.out.printf("The character's current attack speed is %.3f", currentAttackSpeed);
        System.out.println();
    }
}