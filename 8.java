// Transaction Interface
interface Transaction {
    void processPayment();
    void refund();
}

// SecurePayment Interface
interface SecurePayment {
    boolean validateTransaction();
}

// Abstract PaymentMethod Class
abstract class PaymentMethod implements Transaction {
    private String transactionId;
    private double amount;
    private String currency;

    // Constructor
    public PaymentMethod(String transactionId, double amount, String currency) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.currency = currency;
    }

    // Getter and Setter for encapsulation
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    // Abstract methods for subclasses to implement
    @Override
    public abstract void processPayment();

    @Override
    public abstract void refund();
}

// CreditCard Class implementing PaymentMethod and SecurePayment
class CreditCard extends PaymentMethod implements SecurePayment {
    private String cardNumber;
    private String cardHolderName;

    // Constructor
    public CreditCard(String transactionId, double amount, String currency, String cardNumber, String cardHolderName) {
        super(transactionId, amount, currency);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    // Implementing processPayment() for CreditCard
    @Override
    public void processPayment() {
        if (validateTransaction()) {
            System.out.println("Processing Credit Card Payment of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid Credit Card Transaction.");
        }
    }

    // Implementing refund() for CreditCard
    @Override
    public void refund() {
        System.out.println("Refunding Credit Card Payment of " + getAmount() + " " + getCurrency());
    }

    // Implementing validateTransaction() for CreditCard
    @Override
    public boolean validateTransaction() {
        // For simplicity, assume card validation is based on card number length
        return cardNumber.length() == 16;
    }
}

// DebitCard Class implementing PaymentMethod and SecurePayment
class DebitCard extends PaymentMethod implements SecurePayment {
    private String cardNumber;
    private String pin;

    // Constructor
    public DebitCard(String transactionId, double amount, String currency, String cardNumber, String pin) {
        super(transactionId, amount, currency);
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    // Implementing processPayment() for DebitCard
    @Override
    public void processPayment() {
        if (validateTransaction()) {
            System.out.println("Processing Debit Card Payment of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid Debit Card Transaction.");
        }
    }

    // Implementing refund() for DebitCard
    @Override
    public void refund() {
        System.out.println("Refunding Debit Card Payment of " + getAmount() + " " + getCurrency());
    }

    // Implementing validateTransaction() for DebitCard
    @Override
    public boolean validateTransaction() {
        // For simplicity, assume valid debit card transaction is based on pin length
        return pin.length() == 4;
    }
}

// PayPal Class implementing PaymentMethod and SecurePayment
class PayPal extends PaymentMethod implements SecurePayment {
    private String email;

    // Constructor
    public PayPal(String transactionId, double amount, String currency, String email) {
        super(transactionId, amount, currency);
        this.email = email;
    }

    // Implementing processPayment() for PayPal
    @Override
    public void processPayment() {
        if (validateTransaction()) {
            System.out.println("Processing PayPal Payment of " + getAmount() + " " + getCurrency());
        } else {
            System.out.println("Invalid PayPal Transaction.");
        }
    }

    // Implementing refund() for PayPal
    @Override
    public void refund() {
        System.out.println("Refunding PayPal Payment of " + getAmount() + " " + getCurrency());
    }

    // Implementing validateTransaction() for PayPal
    @Override
    public boolean validateTransaction() {
        // For simplicity, assume valid PayPal transaction is based on a valid email format
        return email.contains("@");
    }
}

// Main Class to demonstrate payment processing
public class OnlinePaymentProcessing {
    public static void main(String[] args) {
        // Create CreditCard instance
        CreditCard creditCard = new CreditCard("TX12345", 200.0, "USD", "1234567812345678", "John Doe");
        creditCard.processPayment();
        creditCard.refund();

        // Create DebitCard instance
        DebitCard debitCard = new DebitCard("TX12346", 100.0, "USD", "9876543212345678", "1234");
        debitCard.processPayment();
        debitCard.refund();

        // Create PayPal instance
        PayPal payPal = new PayPal("TX12347", 150.0, "USD", "user@example.com");
        payPal.processPayment();
        payPal.refund();
    }
}
