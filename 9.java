// Lendable Interface
interface Lendable {
    void borrowItem();
    void returnItem();
}

// DigitalAccess Interface
interface DigitalAccess {
    void onlineReading();
}

// Abstract LibraryItem Class
abstract class LibraryItem {
    private String title;
    private String author;
    private String itemId;

    // Constructor
    public LibraryItem(String title, String author, String itemId) {
        this.title = title;
        this.author = author;
        this.itemId = itemId;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getItemId() {
        return itemId;
    }
}

// Book Class
class Book extends LibraryItem implements Lendable {
    public Book(String title, String author, String itemId) {
        super(title, author, itemId);
    }

    @Override
    public void borrowItem() {
        System.out.println("Borrowing book: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning book: " + getTitle());
    }
}

// Magazine Class
class Magazine extends LibraryItem implements Lendable {
    public Magazine(String title, String author, String itemId) {
        super(title, author, itemId);
    }

    @Override
    public void borrowItem() {
        System.out.println("Borrowing magazine: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning magazine: " + getTitle());
    }
}

// DVD Class
class DVD extends LibraryItem implements Lendable {
    public DVD(String title, String author, String itemId) {
        super(title, author, itemId);
    }

    @Override
    public void borrowItem() {
        System.out.println("Borrowing DVD: " + getTitle());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning DVD: " + getTitle());
    }
}

// DigitalBook Class implementing DigitalAccess
class DigitalBook extends Book implements DigitalAccess {
    public DigitalBook(String title, String author, String itemId) {
        super(title, author, itemId);
    }

    @Override
    public void onlineReading() {
        System.out.println("Reading digital book online: " + getTitle());
    }
}

// Main class to test Library System
public class LibrarySystem {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", "John Doe", "B001");
        book.borrowItem();
        book.returnItem();

        DigitalBook digitalBook = new DigitalBook("Learning Java", "Jane Doe", "B002");
        digitalBook.borrowItem();
        digitalBook.returnItem();
        digitalBook.onlineReading();
    }
}
