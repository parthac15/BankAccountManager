import java.util.HashMap;

public class BankAccountManager {
    private HashMap<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean deleteAccount(String accountNumber) {
        return accounts.remove(accountNumber) != null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            for (BankAccount account : accounts.values()) {
                System.out.println(account);
            }
        }
    }

    public boolean updateAccountHolder(String accountNumber, String newHolderName) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.setAccountHolder(newHolderName);
            return true;
        }
        return false;
    }

    public boolean updateAccountBalance(String accountNumber, double newBalance) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.setBalance(newBalance);
            return true;
        }
        return false;
    }
}
