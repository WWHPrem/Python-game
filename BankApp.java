import java.util.Scanner;

class BankAccount {
    private final String owner;
    private double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public String getOwner() {
        return owner;
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        BankAccount account = new BankAccount(name, 5000.0); // initial ₹5000

        int choice;
        do {
            System.out.println("\nHi " + account.getOwner());
            System.out.println("1. Deposit\n2. Withdraw\n3. Show Balance\n4. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Deposit ₹: ");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Withdraw ₹: ");
                    double wd = scanner.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    System.out.println("Thanks for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
