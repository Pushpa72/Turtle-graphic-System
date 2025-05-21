public class Transactions {
    public static void main(String[] args) {
        Account account1 = new Account("Pushpa Rimal", 12345, 5000000.0);
        Account account2 = new Account("Rohan Raj", 67890);
        System.out.println(account1.toString());
        System.out.println();
        System.out.println(account2.toString());
        account1.deposit(20000.0);
        account1.withdraw(1000.0);

        account2.deposit(150809.0);

        System.out.println("After Transactions:");
        System.out.println(account1.toString());
        System.out.println();
        System.out.println(account2.toString());
    }
}