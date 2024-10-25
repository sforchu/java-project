package myio.myscanner;

import java.util.Scanner;
public class MyIOClass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // String name = input.nextLine();
        System.out.println("Enter the Temperature in celsius");
        float temp = input.nextFloat();
        System.out.println("your temperature in Fahrenheit is");

        float fara = (temp * 9 /5 + 32);

        System.out.println(fara);
    }
}