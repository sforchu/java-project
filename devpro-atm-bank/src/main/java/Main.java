import data.DatabaseConnection;
import model.Account;
import model.Transaction;
import repository.AccountRepository;

import java.sql.Connection;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.createConnection();
        AccountRepository accountRepository = new AccountRepository(connection);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter account number");
        String accountNumber = scanner.next();

        System.out.println("Enter pin");
        int pin = scanner.nextInt();

        Account account = accountRepository.getAccount(accountNumber, pin);

        if (account != null) {

            System.out.println("---------------Account information-------------------");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Name: " + account.getAccountName());

            System.out.println("---------------Transaction information----------------");
            for (Transaction txn : account.getTransactions()) {
                System.out.println("ID: " + txn.getId());
                System.out.println("Amount: $" + txn.getAmount());
                System.out.println("Date: " + txn.getTransactionDate());
                System.out.println();
            }
            System.out.println("-------------------------------------------------------");
        } else {
            System.out.println("Wrong account. Press 1 to create an account or any number to exit");
            int createAcc = scanner.nextInt();
            if (createAcc == 1) {
                System.out.println("Create Account Number: ");
                String accNumber = scanner.next();

                System.out.println("Create Account Name: ");
                String accName = scanner.next();

                System.out.println("Create pin: ");
                int accPin = scanner.nextInt();

                System.out.println("Initial deposit: ");
                double initialDeposit = scanner.nextDouble();

                accountRepository.createAccount(accNumber, accName, accPin, initialDeposit);
                System.out.println("Account created successfully");
            }
            return;
        }

        while (true) {
            System.out.println("Enter 1 to make a DEPOSIT or 2 to make a WITHDRAWAL");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to DEPOSIT: ");
                    double depositAmount = scanner.nextDouble();
                    accountRepository.makeTransaction(accountNumber, depositAmount);
                    break;
                case 2:
                    System.out.println("Enter amount to WITHDRAW: ");
                    double withdrawAmount = scanner.nextDouble();
                    accountRepository.makeTransaction(accountNumber, withdrawAmount);
                    break;
                default:
                    System.out.println("Invalid key pressed!");
            }
        }

    }
}
