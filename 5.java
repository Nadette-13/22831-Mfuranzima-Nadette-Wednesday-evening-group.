// Interface: LibraryItem
interface LibraryItem {
    String getTitle();
    String getItemId();
    boolean checkAvailability();
}

// Abstract Class: LibraryMaterial
abstract class LibraryMaterial implements LibraryItem {
    protected String title;
    protected String itemId;
    protected boolean isAvailable;

    public LibraryMaterial(String title, String itemId, boolean isAvailable) {
        this.title = title;
        this.itemId = itemId;
        this.isAvailable = isAvailable;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        isAvailable = availability;
    }

    public abstract void displayDetails();
}

// Subclass: Book
class Book extends LibraryMaterial {
    private String author;

    public Book(String title, String itemId, boolean isAvailable, String author) {
        super(title, itemId, isAvailable);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemId);
        System.out.println("Author: " + author);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Subclass: DVD
class DVD extends LibraryMaterial {
    private int duration; // Duration in minutes

    public DVD(String title, String itemId, boolean isAvailable, int duration) {
        super(title, itemId, isAvailable);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("DVD Details:");
        System.out.println("Title: " + title);
        System.out.println("Item ID: " + itemId);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create instances of Book and DVD
        Book book1 = new Book("The Great Gatsby", "B001", true, "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "B002", false, "George Orwell");
        DVD dvd1 = new DVD("Inception", "D001", true, 148);
        DVD dvd2 = new DVD("The Matrix", "D002", false, 136);

        // Create an array of LibraryItem to demonstrate polymorphism
        LibraryItem[] libraryItems = {book1, book2, dvd1, dvd2};

        // Display details of all library items
        System.out.println("Library Inventory:");
        for (LibraryItem item : libraryItems) {
            if (item instanceof LibraryMaterial) {
                ((LibraryMaterial) item).displayDetails();
                System.out.println();
            }
        }

        // Update availability and display updated details
        System.out.println("Updating availability...");
        book2.setAvailability(true);
        dvd2.setAvailability(true);

        System.out.println("\nUpdated Library Inventory:");
        for (LibraryItem item : libraryItems) {
            if (item instanceof LibraryMaterial) {
                ((LibraryMaterial) item).displayDetails();
                System.out.println();
            }
        }
    }
}
