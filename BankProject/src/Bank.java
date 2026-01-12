import java.util.*;

public class Bank {
    private Map<Integer, Account> accounts;
    private List<Transaction> transactions;

    public Bank() {
        Object[] data = DataStore.load();
        accounts = (Map<Integer, Account>) data[0];
        transactions = (List<Transaction>) data[1];
    }

    public void createAccount(Account acc) {
        accounts.put(acc.getAccountNumber(), acc);
        save();
    }

    public Account getAccount(int accNo) throws AccountNotFoundException {
        if (!accounts.containsKey(accNo))
            throw new AccountNotFoundException("Account not found");
        return accounts.get(accNo);
    }

    public void deposit(int accNo, int pin, double amount) throws AccountNotFoundException {
        Account acc = getAccount(accNo);
        if (!acc.validatePin(pin)) {
            System.out.println("Invalid PIN");
            return;
        }
        acc.deposit(amount);
        transactions.add(new Transaction(accNo, "Deposit", amount));
        save();
    }

    public void withdraw(int accNo, int pin, double amount) throws AccountNotFoundException {
        Account acc = getAccount(accNo);
        if (!acc.validatePin(pin)) {
            System.out.println("Invalid PIN");
            return;
        }
        acc.withdraw(amount);
        transactions.add(new Transaction(accNo, "Withdraw", amount));
        save();
    }


    public void showAccounts() {
        accounts.values().forEach(System.out::println);
    }

    public void showTransactions() {
        transactions.forEach(System.out::println);
    }

    private void save() {
        DataStore.save(accounts, transactions);
    }
}
