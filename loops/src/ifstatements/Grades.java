
package ifstatements;


import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your score");
        float ny_score = input.nextFloat();
        if (ny_score > 80) {
            System.out.println("A-Grade, Excellent");
        } else {
            if (ny_score > 60) {
                System.out.println("B-Grade, Very Good");
            } else {
                if (ny_score > 50) {
                    System.out.println("C-Grade, Fair");
                } else {
                    if (ny_score > 30) {
                        System.out.println("D-Grade, Abraham \uD83D\uDE06");
                    } else {
                        System.out.println("F-Grade, Fail try again next year");
                    }
                }
            }
        }

    }
}
