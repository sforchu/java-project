package bankApp;

// creating a class Account
public class Account {
    private String name;
    private double balance;

    // Constructor of the class Account
    public Account(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // A deposit method that throws Exception and has a try block to catch situation where deposit amount is more than 5000
    public double deposit(double amount) throws MaximumLimitException {
        if (amount > 5000) {
            throw new MaximumLimitException("Deposit limit");
        }
        this.balance = this.balance + amount;
        return this.balance;
    }


    // A withdrawal method that throws Exception and has a try block to catch situations where withdraw amount is more than 2000
    public double withdraw(double amount) throws MaximumLimitException {
        if (amount > 2000) {
            throw new MaximumLimitException("Withdraw limit");
        }
        this.balance = this.balance - amount;
        return this.balance;
    }


}
