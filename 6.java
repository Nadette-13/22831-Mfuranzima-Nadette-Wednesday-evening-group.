// Interface: Shippable
interface Shippable {
    double calculateShippingCost();
    String getDeliveryTime();
}

// Abstract Class: Product
abstract class Product implements Shippable {
    private String name;
    private double price;
    private double weight; // Weight in kilograms

    public Product(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public abstract void displayDetails();
}

// Subclass: Electronics
class Electronics extends Product {
    private int warrantyPeriod; // Warranty in months

    public Electronics(String name, double price, double weight, int warrantyPeriod) {
        super(name, price, weight);
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public double calculateShippingCost() {
        // Example: $5 base fee + $2 per kilogram
        return 5 + (2 * getWeight());
    }

    @Override
    public String getDeliveryTime() {
        return "3-5 business days";
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        System.out.println("Electronics:");
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Warranty: " + warrantyPeriod + " months");
        System.out.println("Shipping Cost: $" + calculateShippingCost());
        System.out.println("Delivery Time: " + getDeliveryTime());
    }
}

// Subclass: Furniture
class Furniture extends Product {
    private String material;

    public Furniture(String name, double price, double weight, String material) {
        super(name, price, weight);
        this.material = material;
    }

    @Override
    public double calculateShippingCost() {
        // Example: $10 base fee + $3 per kilogram
        return 10 + (3 * getWeight());
    }

    @Override
    public String getDeliveryTime() {
        return "5-7 business days";
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void displayDetails() {
        System.out.println("Furniture:");
        System.out.println("Name: " + getName());
        System.out.println("Price: $" + getPrice());
        System.out.println("Weight: " + getWeight() + " kg");
        System.out.println("Material: " + material);
        System.out.println("Shipping Cost: $" + calculateShippingCost());
        System.out.println("Delivery Time: " + getDeliveryTime());
    }
}

// Customer Class
class Customer {
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Product product) {
        System.out.println("Order Details:");
        System.out.println("Customer: " + name);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        product.displayDetails();
        System.out.println("Total Price (Including Shipping): $" + (product.getPrice() + product.calculateShippingCost()));
        System.out.println();
    }
}

// Main Class
public class ECommerceOrderSystem {
    public static void main(String[] args) {
        // Create products
        Electronics laptop = new Electronics("Laptop", 1200.00, 2.5, 24);
        Furniture chair = new Furniture("Office Chair", 150.00, 10.0, "Leather");

        // Create a customer
        Customer customer = new Customer("Alice Johnson", "alice@example.com", "123 Elm Street");

        // Place orders
        customer.placeOrder(laptop);
        customer.placeOrder(chair);
    }
}
