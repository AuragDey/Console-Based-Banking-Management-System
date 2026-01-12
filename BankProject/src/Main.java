import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Accounts");
            System.out.println("6. View Transactions");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Acc No: ");
                        int no = sc.nextInt();
                        System.out.print("Name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Set 4-digit PIN: ");
                        int pin = sc.nextInt();
                        bank.createAccount(new SavingsAccount(no, name, 0, pin));
                    }
                    case 2 -> {
                        System.out.print("Acc No: ");
                        int no = sc.nextInt();
                        System.out.print("Name: ");
                        sc.nextLine(); // consume newline
                        String name = sc.nextLine();
                        System.out.print("Set 4-digit PIN: ");
                        int pin = sc.nextInt();
                        bank.createAccount(new CurrentAccount(no, name, 0, pin));
                    }

                    case 3 -> {
                        System.out.print("Acc No: ");
                        int accNo = sc.nextInt();
                        System.out.print("PIN: ");
                        int pin = sc.nextInt();
                        System.out.print("Amount: ");
                        double amount = sc.nextDouble();
                        bank.deposit(accNo, pin, amount);
                    }
                    case 4 -> {
                        System.out.print("Acc No: ");
                        int accNo = sc.nextInt();
                        System.out.print("PIN: ");
                        int pin = sc.nextInt();
                        System.out.print("Amount: ");
                        double amount = sc.nextDouble();
                        bank.withdraw(accNo, pin, amount);
                    }
                    case 5 -> bank.showAccounts();
                    case 6 -> bank.showTransactions();
                    case 0 -> System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }
}
