package phonebook;

import java.util.UUID;

public class User {

    public UUID id;
    public String name;
    public int phoneNumber;
    public String email;

    public User() {

    }

    public User(UUID id, String name, int phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullInfo() {
        return name + "\t\t\t" + phoneNumber + "\t\t\t" + email;
    }
}
