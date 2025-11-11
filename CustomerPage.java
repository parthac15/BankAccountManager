import java.util.Scanner;

public class CustomerPage {
    private BankAccountManager manager;
    private Scanner scanner;

    public CustomerPage(BankAccountManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.print("Enter your account number: ");
        String accNum = scanner.nextLine();

        BankAccount account = manager.getAccount(accNum);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("\n--- Customer Page ---");
            System.out.println("1. View Account Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit to Main Menu");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.println(account);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Enter a valid amount.");
                        scanner.nextLine();
                    }
                    double depo = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(depo);
                    System.out.println("Deposit successful. New balance: " + account.getBalance());
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Enter a valid amount.");
                        scanner.nextLine();
                    }
                    double with = scanner.nextDouble();
                    scanner.nextLine();
                    if (account.withdraw(with)) {
                        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting Customer Page...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
