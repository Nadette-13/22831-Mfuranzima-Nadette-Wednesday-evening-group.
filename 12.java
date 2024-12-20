// BankingOperations Interface
interface BankingOperations {
    void deposit(double amount);
    void withdraw(double amount);
    double checkBalance();
}

// LoanEligible Interface
interface LoanEligible {
    void applyForLoan(double amount);
    void checkLoanStatus();
}

// Abstract Account Class
abstract class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

// SavingsAccount Class
class SavingsAccount extends Account implements BankingOperations, LoanEligible {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited " + amount + ". New Balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + ". New Balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for " + amount);
    }

    @Override
    public void checkLoanStatus() {
        System.out.println("Checking loan status...");
    }
}

// CheckingAccount Class
class CheckingAccount extends Account implements BankingOperations {
    public CheckingAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited " + amount + ". New Balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrew " + amount + ". New Balance: " + getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }
}

// FixedDeposit Class
class FixedDeposit extends Account implements BankingOperations {
    public FixedDeposit(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Deposited " + amount + ". New Balance: " + getBalance());
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawal not allowed for Fixed Deposit accounts.");
    }

    @Override
    public double checkBalance() {
        return getBalance();
    }
}

// Main class to test Banking Application
public class BankingSystem {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("S001", "John Doe", 5000.0);
        savings.deposit(1000.0);
        savings.withdraw(2000.0);
        savings.checkBalance();
        savings.applyForLoan(5000.0);

        CheckingAccount checking = new CheckingAccount("C001", "Jane Doe", 3000.0);
        checking.deposit(500.0);
        checking.withdraw(1500.0);
        checking.checkBalance();

        FixedDeposit fd = new FixedDeposit("FD001", "Mark Smith", 10000.0);
        fd.deposit(2000.0);
        fd.withdraw(1000.0); // This should show an error message
        fd.checkBalance();
    }
}
