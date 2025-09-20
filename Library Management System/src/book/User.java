package book;

import java.util.Objects;

public class User {
    private static int counter = 1;
    private final int id;
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String username;
    private final String password;
    private final boolean isAdmin;

    public User(String firstName, String middleName, String lastName, String username, String password, boolean isAdmin) {
        this.id = counter++;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
