import java.util.Scanner;

public class Band {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello, Welcome to Band-name Generator");
        System.out.println("What is your Pet's name");
        String name = input.nextLine();
        System.out.println("What city do you live in");
        String city = input.nextLine();
        System.out.println("Your Band name is" + " " + name +"-"+ city);



    }
}
