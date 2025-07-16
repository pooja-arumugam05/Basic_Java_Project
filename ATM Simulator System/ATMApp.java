import java.util.Scanner;
class UserAccount {
    private int pin;
    private double balance;

    public UserAccount(int pin, double balance) {
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" ₹" + amount + " deposited successfully.");
        } else {
            System.out.println(" Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println(" Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println(" Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        }
    }
}
class ATM {
    private UserAccount user;

    public ATM(UserAccount user) {
        this.user = user;
    }

    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: ₹" + user.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ₹");
                    double deposit = sc.nextDouble();
                    user.deposit(deposit);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdraw = sc.nextDouble();
                    user.withdraw(withdraw);
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
public class ATMApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserAccount account = new UserAccount(1234, 10000);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter your PIN: ");
        int inputPin = sc.nextInt();

        if (account.validatePin(inputPin)) {
            ATM atm = new ATM(account);
            atm.showMenu();
        } else {
            System.out.println("Incorrect PIN. Access Denied.");
        }
    }
}
