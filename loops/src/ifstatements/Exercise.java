package ifstatements;

import java.util.Scanner;

public class Exercise {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter firstNum");
        float firstNum = input.nextFloat();
        System.out.println("Enter secondNum");
        float secondNum = input.nextFloat();
        System.out.println("Enter thirdNum");
        float thirdNum = input.nextFloat();
        if (firstNum > secondNum && firstNum > thirdNum) {
            System.out.println(firstNum + " firstNum is biggest");
        } else {
            if (secondNum > firstNum && secondNum > thirdNum) {
                System.out.println(secondNum + " secondNum is biggest");

            } else {
                System.out.println(thirdNum + " thirdNum is biggest");
            }
        }

        }


    }

