package ifstatements;

import java.util.Arrays;
import java.util.Scanner;

public class Assign {
    public static void main(String[] args) {
        int[] num = new int[10];
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < num.length; i++) {
            System.out.println("Enter number" + (i + 1) + ": ");
            num[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(num));

        for (int i = num.length - 1; i >= 0; i--) {
            System.out.println(num[i] + "\t");
        }
    }
}