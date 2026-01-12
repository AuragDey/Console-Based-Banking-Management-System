import java.io.Serializable;
import java.time.LocalDateTime;

public class Transaction implements Serializable {
    private int accountNumber;
    private String type;
    private double amount;
    private LocalDateTime date;

    public Transaction(int accNo, String type, double amount) {
        this.accountNumber = accNo;
        this.type = type;
        this.amount = amount;
        this.date = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return date + " | " + type + " | ₹" + amount;
    }
}
