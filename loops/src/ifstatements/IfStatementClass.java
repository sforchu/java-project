package ifstatements;

import java.util.Scanner;

public class IfStatementClass {
    public static void main(String[] args) {
        // if else statement
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your age:");
        int age = input.nextInt();

        // if else statement
        if (age >= 18) {
            System.out.println("You are eligible to vote");

        } else {
            System.out.println("You are not eligible to vote");
        }

    }
}
