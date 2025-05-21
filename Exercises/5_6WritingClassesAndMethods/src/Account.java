public class Account {
    private String name;
    private int accountNumber;
    private double balance;

    // Constructor to initialize name, account number, and balance
    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Constructor for name and account number (initial balance = 0)
    public Account(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for account number
    public int getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // toString method to display account information
    @Override
    public String toString() {
        return "Account Details:\n" +
                "Name: " + name + "\n" +
                "Account Number: " + accountNumber + "\n" +
                "Balance: $" + balance;
    }
}