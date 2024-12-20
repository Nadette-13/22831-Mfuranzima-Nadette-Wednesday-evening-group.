import java.time.LocalDate;

// Base Class: Product
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract double getDiscountedPrice();

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Final Price after Discount: $" + getDiscountedPrice());
    }
}

// Subclass: Electronics
class Electronics extends Product {
    private int warrantyPeriod; // in months
    private String brand;

    public Electronics(String productId, String name, double price, int warrantyPeriod, String brand) {
        super(productId, name, price);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public double getDiscountedPrice() {
        // Example: 10% discount for electronics
        return getPrice() * 0.90;
    }
}

// Subclass: Clothing
class Clothing extends Product {
    private String size;
    private String material;

    public Clothing(String productId, String name, double price, String size, String material) {
        super(productId, name, price);
        this.size = size;
        this.material = material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public double getDiscountedPrice() {
        // Example: 20% seasonal discount for clothing
        return getPrice() * 0.80;
    }
}

// Subclass: Groceries
class Groceries extends Product {
    private LocalDate expiryDate;

    public Groceries(String productId, String name, double price, LocalDate expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isNearExpiry() {
        // Consider near expiry if the expiry date is within 7 days from today
        return expiryDate.isBefore(LocalDate.now().plusDays(7));
    }

    @Override
    public double getDiscountedPrice() {
        // No discount on groceries
        return getPrice();
    }
}

// Main Class
public class ECommerceSystem {
    public static void main(String[] args) {
        // Creating instances of different product types
        Product laptop = new Electronics("E001", "Laptop", 1200.00, 24, "Dell");
        Product shirt = new Clothing("C001", "T-Shirt", 25.00, "L", "Cotton");
        Product milk = new Groceries("G001", "Milk", 2.50, LocalDate.now().plusDays(5));

        // Display product details
        Product[] products = {laptop, shirt, milk};
        for (Product product : products) {
            product.displayDetails();
            System.out.println();
        }

        // Check if a grocery item is near expiry
        if (((Groceries) milk).isNearExpiry()) {
            System.out.println("The grocery item '" + milk.getName() + "' is near expiry.");
        } else {
            System.out.println("The grocery item '" + milk.getName() + "' is not near expiry.");
        }
    }
}
