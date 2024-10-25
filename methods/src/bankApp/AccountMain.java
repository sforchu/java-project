package bankApp;

import java.util.Scanner;

// creating a class AccountMain that has the main method where my code will be executed! The method has some if statements for specific scenarios execution
public class AccountMain {
    public static void main(String[] args) {
        Account smith = new Account("smith", 5000);
        Scanner input = new Scanner(System.in);
        double amount = 5000;
        System.out.println("Welcome to bankApp! What will you like to do today? Press '1' for Depositing or '2' for Withdrawal");
        int choice = input.nextInt();
        if (choice == 1) {
            System.out.println("Deposit, what amount do you want to deposit?");
            double depositAmount = input.nextDouble();

            try {
                double newDeposit = smith.deposit(depositAmount);
                System.out.println("Your new Account balance is $" + newDeposit);
            } catch (MaximumLimitException ex) {
                System.out.println("Your new Account balance is $" + amount);
                System.out.println("Sorry you have reach the maximum deposit amount per transaction. Please deposit a lesser amount");
            } finally {
                System.out.println("try catch code is done \uD83D\uDC4D");
            }

        } else if (choice == 2) {
            System.out.println("Withdraw, what amount do you want to withdraw?");
            double withdrawAmount = input.nextDouble();
            try {
                double newWithdraw = smith.withdraw(withdrawAmount);
                System.out.println("Your new Account balance is $" + newWithdraw);

            } catch (MaximumLimitException ex) {
                System.out.println("Your new Account balance is $" + amount);
                System.out.println("Sorry you have reach the maximum withdraw amount per transaction. Please withdraw a lesser amount");

            } finally {
                System.out.println("try catch code is done \uD83D\uDC4D");
            }

        } else {
            System.out.println("Invalid Option, Please select either 1 or 2");
        }

    }
}
