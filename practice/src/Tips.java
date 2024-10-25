import java.util.Scanner;

public class Tips {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator");
        System.out.println("What is the total bill");
        float bill = input.nextFloat();
        System.out.println("what percentage tip would you like to give? 10, 12, or 15? 12");
        float tip = input.nextFloat();
        float tip_amount = ((tip * bill) / 100) + bill;
        System.out.println("Total bill is " + tip_amount);
        System.out.println("How many people to split the bill?");
        int t_people = input.nextInt();
        float pay_per_person = tip_amount / t_people;
        System.out.println("Each person should pay:" + " $" + pay_per_person);


    }
}
