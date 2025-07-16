abstract class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public abstract int getMaxBorrowDays();

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean status) {
        this.isAvailable = status;
    }
}

class DigitalBook extends Book {
    public DigitalBook(String title, String author) {
        super(title, author);
    }

    public int getMaxBorrowDays() {
        return 7;
    }
}

class PhysicalBook extends Book {
    public PhysicalBook(String title, String author) {
        super(title, author);
    }

    public int getMaxBorrowDays() {
        return 14;
    }
}

abstract class User {
    private String name;
    private String userId;

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public abstract int getMaxBooksAllowed();

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}

class Student extends User {
    public Student(String name, String userId) {
        super(name, userId);
    }

    public int getMaxBooksAllowed() {
        return 3;
    }
}

class Faculty extends User {
    public Faculty(String name, String userId) {
        super(name, userId);
    }

    public int getMaxBooksAllowed() {
        return 5;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        // Create users
        Student student = new Student("Pooja", "S101");
        Faculty faculty = new Faculty("Dr. Arun", "F202");

        // Create books
        DigitalBook db = new DigitalBook("Java Basics", "James Gosling");
        PhysicalBook pb = new PhysicalBook("OOP Concepts", "Grady Booch");

        // Borrow logic
        borrowBook(student, db);
        borrowBook(faculty, pb);
        borrowBook(faculty, db); // Already borrowed

        // Returning the book manually for testing
        db.setAvailability(true);
        borrowBook(faculty, db); // Now possible again
    }

    public static void borrowBook(User user, Book book) {
        if (book.isAvailable()) {
            System.out.println(user.getName() + " borrowed \"" + book.getTitle() + "\" for " +
                    book.getMaxBorrowDays() + " days.");
            book.setAvailability(false);
        } else {
            System.out.println("Sorry! \"" + book.getTitle() + "\" is currently unavailable.");
        }
    }
}
