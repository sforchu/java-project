package ifstatements;

import java.util.Scanner;

public class Exer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("number");
        int sum = 0;
        int ny_score = input.nextInt();
        for (int i = 1; i <= ny_score ; i++) {
            sum += i;
        }
        System.out.println(sum);
    }}