import java.util.Scanner;

public class LoveCalc {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        String name1 = input.nextLine();
        String name1_lower = name1.toLowerCase();
        System.out.println("What is your Lover's name?");
        String name2 = input.nextLine();
        String name2_lower = name2.toLowerCase();
        String c_name = name1_lower + name2_lower;
        System.out.println(c_name);



    }
}
