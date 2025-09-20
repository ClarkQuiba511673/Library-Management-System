package book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Library {
    private final List<User> users = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private User loggedInUser = null;

    public Library() {
        books.add(new Book("Java Programming", 3));
        books.add(new Book("Data Structures", 2));
        books.add(new Book("Introduction to Algorithms", 4));
        books.add(new Book("Clean Code", 5));
        books.add(new Book("Design Patterns", 3));
        books.add(new Book("Operating System Concepts", 2));
        books.add(new Book("Computer Networks", 4));
        books.add(new Book("Artificial Intelligence: A Modern Approach", 3));
        books.add(new Book("Database System Concepts", 2));
        books.add(new Book("Software Engineering", 3));
        books.add(new Book("Effective Java", 4));
        books.add(new Book("Programming in Python", 5));
        books.add(new Book("Web Development with HTML/CSS/JS", 6));
        books.add(new Book("Mobile App Development with Flutter", 3));
        books.add(new Book("Machine Learning with Python", 4));
        books.add(new Book("Cybersecurity Essentials", 2));


        // Hardcoded admin
        User admin = new User("Admin", "", "Account", "admin", "admin123", true);
        users.add(admin);
    }

    public void start() {
        while (true) {
            try {
                if (loggedInUser == null) {
                    System.out.println("\n--- Welcome to the Library System ---");
                    System.out.println("1. Register");
                    System.out.println("2. Login");
                    System.out.println("3. Exit");
                    System.out.print("Choose: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        case 1 -> register();
                        case 2 -> login();
                        case 3 -> {
                            System.out.println("Goodbye!");
                            return;
                        }
                        default -> System.out.println("Invalid option.");
                    }
                } else {
                    if (loggedInUser.isAdmin()) {
                        showAdminMenu();
                    } else {
                        showUserMenu();
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input type. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void register() {
        try {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine().trim();
            if (!firstName.matches("[a-zA-Z]+")) {
                System.out.println("First name must contain only letters.");
                return;
            }

            System.out.print("Middle Name: ");
            String middleName = scanner.nextLine().trim();
            if (!middleName.matches("[a-zA-Z]*")) {
                System.out.println("Middle name must contain only letters.");
                return;
            }

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine().trim();
            if (!lastName.matches("[a-zA-Z]+")) {
                System.out.println("Last name must contain only letters.");
                return;
            }

            System.out.print("Username: ");
            String username = scanner.nextLine().trim();
            if (username.isEmpty() || username.length() < 3) {
                System.out.println("Username must be at least 3 characters.");
                return;
            }

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already exists!");
                    return;
                }
            }

            System.out.print("Password: ");
            String password = scanner.nextLine().trim();
            if (password.length() < 3) {
                System.out.println("Password must be at least 3 characters.");
                return;
            }

            User newUser = new User(firstName, middleName, lastName, username, password, false);
            users.add(newUser);
            System.out.println("Registered successfully! Your ID is: " + newUser.getId());
        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }

    private void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.checkPassword(password)) {
                loggedInUser = user;
                System.out.println("Welcome, " + user.getFullName());

                // Show available books
                System.out.println("\nAvailable Books:");
                for (int i = 0; i < books.size(); i++) {
                    Book b = books.get(i);
                    if (b.getQuantity() > 0 && !b.isReserved()) {
                        System.out.println(i + ". " + b.getTitle() + " (Quantity: " + b.getQuantity() + ")");
                    }
                }
                return;
            }
        }

        System.out.println("Invalid credentials!");
    }

    private void showUserMenu() {
        try {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Borrow Book");
            System.out.println("2. Return Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Logout");
            System.out.print("Choose: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> borrowBook();
                case 2 -> returnBook();
                case 3 -> reserveBook();
                case 4 -> {
                    System.out.println("Logged out.");
                    loggedInUser = null;
                }
                default -> System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private void showAdminMenu() {
        try {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Approve Returns");
            System.out.println("2. Approve Reservations");
            System.out.println("3. Logout");
            System.out.print("Choose: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> approveReturns();
                case 2 -> approveReservations();
                case 3 -> {
                    System.out.println("Logged out.");
                    loggedInUser = null;
                }
                default -> System.out.println("Invalid option.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private void borrowBook() {
        System.out.println("Available Books:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getQuantity() > 0 && !b.isReserved()) {
                System.out.println(i + ". " + b.getTitle() + " (Quantity: " + b.getQuantity() + ")");
            }
        }

        try {
            System.out.print("Enter book number to borrow: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < books.size()) {
                Book book = books.get(index);
                if (book.getQuantity() > 0 && !book.isReserved()) {
                    book.requestBorrow();
                    System.out.println("You borrowed: " + book.getTitle());
                } else {
                    System.out.println("Book is not available.");
                }
            } else {
                System.out.println("Invalid index.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private void returnBook() {
        System.out.println("Borrowed Books:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isBorrowed() && !b.isReturnPending()) {
                System.out.println(i + ". " + b.getTitle());
            }
        }

        try {
            System.out.print("Enter book number to return: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < books.size()) {
                Book book = books.get(index);
                if (book.isBorrowed()) {
                    book.requestReturn();
                    System.out.println("Return request sent for: " + book.getTitle());
                } else {
                    System.out.println("Book is not borrowed.");
                }
            } else {
                System.out.println("Invalid index.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private void reserveBook() {
        System.out.println("Books available for reservation:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (!b.isReserved() && !b.isBorrowed() && !b.isReservePending()) {
                System.out.println(i + ". " + b.getTitle());
            }
        }

        try {
            System.out.print("Enter book number to reserve: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < books.size()) {
                Book book = books.get(index);
                if (!book.isReserved() && !book.isBorrowed()) {
                    book.requestReserve();
                    System.out.println("Reservation request sent for: " + book.getTitle());
                } else {
                    System.out.println("Book is not available.");
                }
            } else {
                System.out.println("Invalid index.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private void approveReturns() {
        System.out.println("Pending Return Requests:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isReturnPending()) {
                System.out.println(i + ". " + b.getTitle());
            }
        }

        try {
            System.out.print("Enter book number to approve return: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < books.size() && books.get(index).isReturnPending()) {
                books.get(index).approveReturn();
                System.out.println("Return approved for: " + books.get(index).getTitle());
            } else {
                System.out.println("Invalid index or no return pending.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }

    private void approveReservations() {
        System.out.println("Pending Reservation Requests:");
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isReservePending()) {
                System.out.println(i + ". " + b.getTitle());
            }
        }

        try {
            System.out.print("Enter book number to approve reservation: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < books.size() && books.get(index).isReservePending()) {
                books.get(index).approveReserve();
                System.out.println("Reservation approved for: " + books.get(index).getTitle());
            } else {
                System.out.println("Invalid index or no reservation pending.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.");
            scanner.nextLine();
        }
    }
}
