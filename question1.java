// Base Class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public abstract void withdraw(double amount);
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + ". New balance: " + getBalance());
        }
    }
}

// Subclass: CheckingAccount
class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance() + overdraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit. Withdrawal denied.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + ". New balance: " + getBalance());
        }
    }
}

// Subclass: FixedDepositAccount
class FixedDepositAccount extends BankAccount {
    private int termInMonths;
    private boolean isTermComplete;

    public FixedDepositAccount(String accountNumber, double balance, int termInMonths) {
        super(accountNumber, balance);
        this.termInMonths = termInMonths;
        this.isTermComplete = false; // Assume term is not complete initially
    }

    public void completeTerm() {
        this.isTermComplete = true;
    }

    @Override
    public void withdraw(double amount) {
        if (!isTermComplete) {
            System.out.println("Withdrawal denied. Term not complete.");
        } else if (amount > getBalance()) {
            System.out.println("Insufficient balance. Withdrawal denied.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn " + amount + ". New balance: " + getBalance());
        }
    }
}

// Utility Class: Bank
class Bank {
    public static void transferFunds(BankAccount from, BankAccount to, double amount) {
        if (amount > 0) {
            from.withdraw(amount);
            if (from.getBalance() >= 0) {
                to.deposit(amount);
                System.out.println("Transferred " + amount + " from " + from.getAccountNumber() + " to " + to.getAccountNumber());
            }
        } else {
            System.out.println("Transfer amount must be positive.");
        }
    }
}

// Main Class
public class BankAccountSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("SA123", 5000, 0.05);
        CheckingAccount checking = new CheckingAccount("CA456", 2000, 1000);
        FixedDepositAccount fixed = new FixedDepositAccount("FD789", 10000, 12);

        savings.deposit(1000);
        savings.withdraw(2000);

        checking.deposit(500);
        checking.withdraw(2500);

        fixed.withdraw(1000); // Term not complete
        fixed.completeTerm();
        fixed.withdraw(1000); // After completing term

        Bank.transferFunds(savings, checking, 500);
    }
}
