package ifstatements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        System.out.println("Enter 5 digits:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(numbers));

        Set<Integer> uniqueNumbers = new HashSet<>();
        boolean duplicateFound = false;

        for (int number : numbers) {
            if (uniqueNumbers.contains(number)) {
                System.out.println("True");
                duplicateFound = true;
                break;
            }
            uniqueNumbers.add(number);
        }

        if (!duplicateFound) {
            System.out.println("False");
        }
    }
}
