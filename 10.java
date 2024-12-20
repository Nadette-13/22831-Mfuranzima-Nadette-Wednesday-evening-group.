// Discountable Interface
interface Discountable {
    void applyDiscount();
    double calculateFinalPrice();
}

// Returnable Interface
interface Returnable {
    void returnProduct();
}

// Abstract Product Class
abstract class Product {
    private String productName;
    private double price;
    private String category;

    // Constructor
    public Product(String productName, double price, String category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // Getters
    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    // Abstract method for subclasses to implement
    public abstract void displayProductDetails();
}

// Electronics Class
class Electronics extends Product implements Discountable, Returnable {
    private double discountRate;

    public Electronics(String productName, double price, String category, double discountRate) {
        super(productName, price, category);
        this.discountRate = discountRate;
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount on Electronics: " + getProductName());
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountRate);
    }

    @Override
    public void returnProduct() {
        System.out.println("Returning Electronics: " + getProductName());
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Electronics: " + getProductName() + " | Price: " + getPrice());
    }
}

// Clothing Class
class Clothing extends Product implements Discountable, Returnable {
    private double discountRate;

    public Clothing(String productName, double price, String category, double discountRate) {
        super(productName, price, category);
        this.discountRate = discountRate;
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount on Clothing: " + getProductName());
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountRate);
    }

    @Override
    public void returnProduct() {
        System.out.println("Returning Clothing: " + getProductName());
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Clothing: " + getProductName() + " | Price: " + getPrice());
    }
}

// Groceries Class
class Groceries extends Product implements Discountable, Returnable {
    private double discountRate;

    public Groceries(String productName, double price, String category, double discountRate) {
        super(productName, price, category);
        this.discountRate = discountRate;
    }

    @Override
    public void applyDiscount() {
        System.out.println("Applying discount on Groceries: " + getProductName());
    }

    @Override
    public double calculateFinalPrice() {
        return getPrice() - (getPrice() * discountRate);
    }

    @Override
    public void returnProduct() {
        System.out.println("Returning Groceries: " + getProductName());
    }

    @Override
    public void displayProductDetails() {
        System.out.println("Groceries: " + getProductName() + " | Price: " + getPrice());
    }
}

// Main class to test Product Management System
public class EcommerceSystem {
    public static void main(String[] args) {
        Electronics electronics = new Electronics("Smartphone", 800.0, "Electronics", 0.1);
        electronics.displayProductDetails();
        electronics.applyDiscount();
        System.out.println("Final Price: " + electronics.calculateFinalPrice());
        electronics.returnProduct();

        Clothing clothing = new Clothing("T-Shirt", 20.0, "Clothing", 0.2);
        clothing.displayProductDetails();
        clothing.applyDiscount();
        System.out.println("Final Price: " + clothing.calculateFinalPrice());
        clothing.returnProduct();

        Groceries groceries = new Groceries("Apple", 5.0, "Groceries", 0.05);
        groceries.displayProductDetails();
        groceries.applyDiscount();
        System.out.println("Final Price: " + groceries.calculateFinalPrice());
        groceries.returnProduct();
    }
}
// Soundable Interface
interface Soundable {
    void makeSound();
}

// Movable Interface
interface Movable {
    void move();
}

// Abstract Animal Class
abstract class Animal {
    private String species;
    private String habitat;
    private String diet;

    // Constructor
    public Animal(String species, String habitat, String diet) {
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
    }

    // Getters
    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    // Abstract method to display animal details
    public abstract void displayAnimalDetails();
}

// Mammal Class
class Mammal extends Animal implements Soundable, Movable {
    public Mammal(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Mammal is roaring.");
    }

    @Override
    public void move() {
        System.out.println("Mammal is running.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Mammal: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Bird Class
class Bird extends Animal implements Soundable, Movable {
    public Bird(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Bird is chirping.");
    }

    @Override
    public void move() {
        System.out.println("Bird is flying.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Bird: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Reptile Class
class Reptile extends Animal implements Soundable, Movable {
    public Reptile(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Reptile is hissing.");
    }

    @Override
    public void move() {
        System.out.println("Reptile is slithering.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Reptile: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Main class to test Animal Classification
public class Zoo {
    public static void main(String[] args) {
        Mammal mammal = new Mammal("Lion", "Savannah", "Carnivore");
        mammal.displayAnimalDetails();
        mammal.makeSound();
        mammal.move();

        Bird bird = new Bird("Eagle", "Mountains", "Carnivore");
        bird.displayAnimalDetails();
        bird.makeSound();
        bird.move();

        Reptile reptile = new Reptile("Snake", "Desert", "Carnivore");
        reptile.displayAnimalDetails();
        reptile.makeSound();
        reptile.move();
    }
}
// Soundable Interface
interface Soundable {
    void makeSound();
}

// Movable Interface
interface Movable {
    void move();
}

// Abstract Animal Class
abstract class Animal {
    private String species;
    private String habitat;
    private String diet;

    // Constructor
    public Animal(String species, String habitat, String diet) {
        this.species = species;
        this.habitat = habitat;
        this.diet = diet;
    }

    // Getters
    public String getSpecies() {
        return species;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getDiet() {
        return diet;
    }

    // Abstract method to display animal details
    public abstract void displayAnimalDetails();
}

// Mammal Class
class Mammal extends Animal implements Soundable, Movable {
    public Mammal(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Mammal is roaring.");
    }

    @Override
    public void move() {
        System.out.println("Mammal is running.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Mammal: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Bird Class
class Bird extends Animal implements Soundable, Movable {
    public Bird(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Bird is chirping.");
    }

    @Override
    public void move() {
        System.out.println("Bird is flying.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Bird: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Reptile Class
class Reptile extends Animal implements Soundable, Movable {
    public Reptile(String species, String habitat, String diet) {
        super(species, habitat, diet);
    }

    @Override
    public void makeSound() {
        System.out.println("Reptile is hissing.");
    }

    @Override
    public void move() {
        System.out.println("Reptile is slithering.");
    }

    @Override
    public void displayAnimalDetails() {
        System.out.println("Reptile: " + getSpecies() + " | Habitat: " + getHabitat() + " | Diet: " + getDiet());
    }
}

// Main class to test Animal Classification
public class Zoo {
    public static void main(String[] args) {
        Mammal mammal = new Mammal("Lion", "Savannah", "Carnivore");
        mammal.displayAnimalDetails();
        mammal.makeSound();
        mammal.move();

        Bird bird = new Bird("Eagle", "Mountains", "Carnivore");
        bird.displayAnimalDetails();
        bird.makeSound();
        bird.move();

        Reptile reptile = new Reptile("Snake", "Desert", "Carnivore");
        reptile.displayAnimalDetails();
        reptile.makeSound();
        reptile.move();
    }
}
