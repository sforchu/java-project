package ifstatements;

import java.util.Scanner;

public class IfStatementWOBracket {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your speed");
        int speed = userInput.nextInt();
        if (speed > 45) //without the {} only the first line after the if is included in the if statement ie System.out.println("you are over speed limit");
            System.out.println("you are over speed limit");
        System.out.println("you have a ticket");


        System.out.println("your speed is: " + speed);
    }
}
