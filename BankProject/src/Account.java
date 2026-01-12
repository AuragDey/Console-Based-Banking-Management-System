import java.io.Serializable;

public abstract class Account implements Serializable {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    private int pin;

    public Account(int accountNumber, String holderName, double balance, int pin) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.pin = pin;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void withdraw(double amount);

    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public String toString() {
        return accountNumber + " | " + holderName + " | Balance: ₹" + balance;
    }
}
