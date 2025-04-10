import java.util.Scanner;

public class ATMSystem {
    static double balance = 1000.00; // initial balance
    static final String USERNAME = "user";
    static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println("=== Welcome to the ATM ===");
        System.out.print("Enter Username: ");
        String user = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pass = scanner.nextLine();

        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            int option;
            do {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit(scanner);
                        break;
                    case 3:
                        withdraw(scanner);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } while (option != 4);
        } else {
            System.out.println("Authentication Failed. Exiting...");
        }

        scanner.close();
    }

    static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }

    static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("Invalid or insufficient funds.");
        }
    }
}
