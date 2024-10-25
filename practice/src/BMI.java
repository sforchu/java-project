import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("what is your weight");
        float weight = input.nextFloat();
        System.out.println("what is your height");
        float height = input.nextFloat();
        float h_index = height * height;
        float bmi = h_index /  weight;
        System.out.println("Your BMI is " + " " + bmi);
    }
}
