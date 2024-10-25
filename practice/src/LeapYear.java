import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Which year do you want to check? ");
        int year = input.nextInt();
        boolean leap_year = year % 4 == 0;
        boolean not_leap = year % 100 == 0;
        boolean leap = year % 400 == 0;
        if (leap_year & not_leap & leap){
            System.out.println(year + " " + "is a leap year");
        }
        else {
            System.out.println(year + " " +  "is not a leap year");
        }

    }
}
