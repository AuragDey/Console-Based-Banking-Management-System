public class CurrentAccount extends Account {

    private final double overdraftLimit = 5000;

    public CurrentAccount(int accNo, String name, double balance, int pin) {
        super(accNo, name, balance, pin);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
        } else {
            System.out.println("Overdraft limit exceeded");
        }
    }
}
