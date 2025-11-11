import java.util.Scanner;

public class Main {
    private static final String MANAGER_PASSWORD = "984319";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccountManager manager = new BankAccountManager();

        manager.addAccount(new BankAccount("101", "John Doe", 1000));
        manager.addAccount(new BankAccount("102", "Jane Smith", 2000));

        boolean running = true;

        while (running) {
            System.out.println("\n--- BANK ACCOUNT SYSTEM ---");
            System.out.println("1. Manager Mode");
            System.out.println("2. Customer Mode");
            System.out.println("3. Exit");
            System.out.print("Select mode: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            int mode = scanner.nextInt();
            scanner.nextLine();

            switch (mode) {
                case 1:
                    if (authenticateManager(scanner)) {
                        managerMode(scanner, manager);
                    } else {
                        System.out.println("Incorrect password. Access denied.");
                    }
                    break;

                case 2:
                    CustomerPage customerPage = new CustomerPage(manager);
                    customerPage.start();
                    break;

                case 3:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }

        scanner.close();
    }

    private static boolean authenticateManager(Scanner scanner) {
        System.out.print("Enter manager password: ");
        String inputPassword = scanner.nextLine();
        return MANAGER_PASSWORD.equals(inputPassword);
    }

    private static void managerMode(Scanner scanner, BankAccountManager manager) {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Manager Mode ---");
            System.out.println("1. Add Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Modify Account");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit to Main Menu");
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
                    System.out.print("Enter account number: ");
                    String accNum = scanner.nextLine();

                    System.out.print("Enter account holder name: ");
                    String holder = scanner.nextLine();

                    System.out.print("Enter initial deposit: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid number for deposit.");
                        scanner.nextLine();
                    }
                    double depo = scanner.nextDouble();
                    scanner.nextLine();

                    manager.addAccount(new BankAccount(accNum, holder, depo));
                    System.out.println("Account added successfully.");
                    break;

                case 2:
                    manager.displayAllAccounts();
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String accDep = scanner.nextLine();

                    System.out.print("Enter deposit amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid number for deposit.");
                        scanner.nextLine();
                    }
                    double amountDep = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount accToDeposit = manager.getAccount(accDep);
                    if (accToDeposit != null) {
                        accToDeposit.deposit(amountDep);
                        System.out.println("Deposited successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String accWith = scanner.nextLine();

                    System.out.print("Enter withdrawal amount: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input. Please enter a valid number for withdrawal.");
                        scanner.nextLine();
                    }
                    double amountWith = scanner.nextDouble();
                    scanner.nextLine();

                    BankAccount accToWithdraw = manager.getAccount(accWith);
                    if (accToWithdraw != null) {
                        if (accToWithdraw.withdraw(amountWith)) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number to modify: ");
                    String accMod = scanner.nextLine();

                    BankAccount accToModify = manager.getAccount(accMod);
                    if (accToModify != null) {
                        System.out.println("Modify:");
                        System.out.println("1. Account Holder Name");
                        System.out.println("2. Account Balance");
                        System.out.print("Select option: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input.");
                            scanner.nextLine();
                            break;
                        }
                        int modChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (modChoice) {
                            case 1:
                                System.out.print("Enter new account holder name: ");
                                String newName = scanner.nextLine();
                                if (manager.updateAccountHolder(accMod, newName)) {
                                    System.out.println("Name updated successfully.");
                                } else {
                                    System.out.println("Update failed.");
                                }
                                break;
                            case 2:
                                System.out.print("Enter new account balance: ");
                                while (!scanner.hasNextDouble()) {
                                    System.out.println("Invalid input. Enter valid balance.");
                                    scanner.nextLine();
                                }
                                double newBal = scanner.nextDouble();
                                scanner.nextLine();
                                if (manager.updateAccountBalance(accMod, newBal)) {
                                    System.out.println("Balance updated successfully.");
                                } else {
                                    System.out.println("Update failed.");
                                }
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.print("Enter account number to delete: ");
                    String accDel = scanner.nextLine();
                    if (manager.deleteAccount(accDel)) {
                        System.out.println("Account deleted successfully.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting Manager Mode...");
                    break;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
