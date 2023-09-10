import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author + ", Available: " + available;
    }
}

class User {
    private String username;
    private String password;
    private List<Book> reservedBooks;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.reservedBooks = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Book> getReservedBooks() {
        return reservedBooks;
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    public void cancelReservation(Book book) {
        reservedBooks.remove(book);
    }
}

class Library {
    private List<Book> books;
    private List<User> users;
    private User loggedInUser;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        loggedInUser = null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public void loginUser(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            System.out.println("Logged in as: " + username);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void logoutUser() {
        loggedInUser = null;
    }

    public void reserveBook(int bookId) {
        if (loggedInUser != null) {
            Book book = findBookById(bookId);
            if (book != null && book.isAvailable()) {
                loggedInUser.reserveBook(book);
                book.setAvailable(false);
                System.out.println("Book reserved successfully.");
            } else {
                System.out.println("Book not found or already reserved.");
            }
        } else {
            System.out.println("You must be logged in to reserve a book.");
        }
    }

    public void cancelReservation(int bookId) {
        if (loggedInUser != null) {
            Book book = findBookById(bookId);
            if (book != null && !book.isAvailable() && loggedInUser.getReservedBooks().contains(book)) {
                loggedInUser.cancelReservation(book);
                book.setAvailable(true);
                System.out.println("Reservation canceled successfully.");
            } else {
                System.out.println("Book not found or you haven't reserved it.");
            }
        } else {
            System.out.println("You must be logged in to cancel a reservation.");
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}

public class library_management {
    public static void main(String[] args) {
        Library library = new Library();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nWelcome to Our Library :");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Add a Book");
                System.out.println("4. Display All Books");
                System.out.println("5. Check Out a Book");
                System.out.println("6. Return a Book");
                System.out.println("7. Reserve a Book");
                System.out.println("8. Cancel Reservation");
                System.out.println("9. Logout");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String newPassword = scanner.nextLine();
                        library.addUser(new User(newUsername, newPassword));
                        System.out.println("User registered successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        library.loginUser(username, password);
                        break;

                    case 3:
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        Book newBook = new Book(library.getBooks().size() + 1, title, author);
                        library.addBook(newBook);
                        System.out.println("Book added successfully!");
                        break;

                    case 4:
                        library.displayBooks();
                        break;

                    case 5:
                        // Check out a book
                        System.out.print("Enter Book ID to check out: ");
                        int checkOutId = scanner.nextInt();
                        Book checkOutBook = library.findBookById(checkOutId);
                        if (checkOutBook != null && checkOutBook.isAvailable()) {
                            checkOutBook.setAvailable(false);
                            System.out.println("Book checked out successfully!");
                        } else {
                            System.out.println("Book not found or already checked out.");
                        }
                        break;

                    case 6:
                        // Return a book
                        System.out.print("Enter Book ID to return: ");
                        int returnId = scanner.nextInt();
                        Book returnBook = library.findBookById(returnId);
                        if (returnBook != null && !returnBook.isAvailable()) {
                            returnBook.setAvailable(true);
                            System.out.println("Book returned successfully!");
                        } else {
                            System.out.println("Book not found or already returned.");
                        }
                        break;

                    case 7:
                        System.out.print("Enter Book ID to reserve: ");
                        int reserveId = scanner.nextInt();
                        library.reserveBook(reserveId);
                        break;

                    case 8:
                        System.out.print("Enter Book ID to cancel reservation: ");
                        int cancelReserveId = scanner.nextInt();
                        library.cancelReservation(cancelReserveId);
                        break;

                    case 9:
                        library.logoutUser();
                        System.out.println("Logged out.");
                        break;

                    case 0:
                        System.out.println("Exiting Library Management System. Goodbye!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid Choice . Enter a valid number (0-9)");
                }
            }
        }
    }
}
