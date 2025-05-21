class BankAccount {
    protected String accountHolder;
    protected String accountNumber;
    protected double balance;
    public BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited to " + accountHolder + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn from " + accountHolder + ". Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
    public void displayAccountInfo() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + String.format("%.2f", balance));
    }
    public void addInterest(double rate) {
        double interest = balance * rate / 100;
        balance += interest;
        System.out.println("Interest of " + interest + " added to " + accountHolder + ". New balance: " + balance);
    }
    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;
    public SavingsAccount(String accountHolder, String accountNumber, double balance, double interestRate) {
        super(accountHolder, accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void addInterest() {
        super.addInterest(interestRate);
    }
}

// Manager
class Bank {
    private SavingsAccount[] accounts = new SavingsAccount[30];
    private int numAccounts = 0;

    public void createAccount(String name, String number, double balance, double interestRate) {
        if (numAccounts >= 30) {
            System.out.println("Cannot create more accounts. Limit reached.");
            return;
        }
        accounts[numAccounts] = new SavingsAccount(name, number, balance, interestRate);
        numAccounts++;
        System.out.println("Account created for " + name + " (" + number + ")");
    }
    public SavingsAccount findAccount(String number) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(number)) {
                return accounts[i];
            }
        }
        return null;
    }
    public void deposit(String accountNumber, double amount) {
        SavingsAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    public void withdraw(String accountNumber, double amount) {
        SavingsAccount acc = findAccount(accountNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }
    public void applyInterestToAll() {
        for (int i = 0; i < numAccounts; i++) {
            accounts[i].addInterest();
        }
        System.out.println("Interest applied to all accounts.\n");
    }
    public void displayAllAccounts() {
        System.out.println("---- All Accounts ----");
        for (int i = 0; i < numAccounts; i++) {
            accounts[i].displayAccountInfo();
            System.out.println();
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("Pushpa Rimal", "001", 5000, 3);
        bank.createAccount("Honey Sigh", "002", 3000, 2.5);
        bank.createAccount("Sita Shrestha", "003", 8000, 4);


        bank.deposit("001", 1500);
        bank.withdraw("002", 1000);
        bank.withdraw("003", 9000);

        bank.applyInterestToAll();
        bank.displayAllAccounts();
    }
}
