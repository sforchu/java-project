package ifstatements;

import java.util.Arrays;
import java.util.Scanner;

public class EqualNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 digits");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(numbers));
        boolean found = false;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println("True");
                break;
            }
        }
        if (!found) {
            System.out.println("False");
        }

    }

}