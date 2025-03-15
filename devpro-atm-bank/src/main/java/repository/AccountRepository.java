package repository;

import model.Account;
import model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AccountRepository {

    private final Connection connection;


    public AccountRepository(Connection connection) {
        this.connection = connection;
    }


    public void createAccount(String accountNumber, String accountName, int pin, double initialDeposit) {
        String insertStatement = "INSERT INTO accounts (account_number, account_name, pin) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

            // Set parameters for the insert statement
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setString(2, accountName);
            preparedStatement.setInt(3, pin);


            //Execute the insert statement
            preparedStatement.executeUpdate();
            makeTransaction(accountNumber, initialDeposit);
        } catch (SQLException e) {
            throw new RuntimeException("A database error occurred" + e.getMessage());
        }
    }


    public void makeTransaction(String accountNumber, double amount) {
        String insertStatement = "INSERT INTO transaction (amount, transaction_date, account_number) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertStatement);

            //set parameters for insert statement
            preparedStatement.setDouble(1, amount);
            preparedStatement.setDate(2, new Date(new java.util.Date().getTime()));
            preparedStatement.setString(3, accountNumber);


            // Execute the insert statement
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error occurred during insert" + e.getMessage());
        }
    }

    public Account getAccount(String accountNumber, int pin) {

        String selectStatement = "SELECT * FROM accounts as acc, transaction as txn " +
                "WHERE acc.account_number = txn.account_number " +
                "AND acc.account_number = ? " +
                "AND acc.pin = ?";

        Account account = null;
        List<Transaction> transactions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectStatement);

            // set parameters for the insert statement
            preparedStatement.setString(1, accountNumber);
            preparedStatement.setInt(2, pin);

            // Execute the insert statement
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                // retrieve data from result set
                String accNum = rs.getNString("account_number");
                String accName = rs.getNString("account_name");
                int accpin = rs.getInt("pin");
                double amount = rs.getDouble("amount");
                Date transactionDate = rs.getDate("transaction_date");
                Long transactionId = rs.getLong("id");

                if (account == null) {
                    account = new Account();
                    account.setAccountNumber(accNum);
                    account.setAccountName(accName);
                    account.setPin(accpin);
                }

                Transaction transaction = new Transaction();
                transaction.setId(transactionId);
                transaction.setAmount(amount);
                transaction.setTransactionDate(transactionDate);
                transaction.setAccount(account);

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new RuntimeException("A database error occurred" + e.getMessage());
        }
        if (account !=null)
            account.setTransactions(transactions);
        return account;
    }


}
