import phonebook.PhoneBook;
import phonebook.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    PhoneBook phoneBook = new PhoneBook();

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();

        main.PhoneBook();
    }

    void PhoneBook() {

        addDefaultUsers();

        String userInput;

        do {
            System.out.println("Welcome to the PHONE BOOK, please choose activity: \n" +
                    "1. Add New User" + "\n" +
                    "2. View All Users" + "\n" +
                    "3. Find User" + "\n" +
                    "4. Update User" + "\n" +
                    "5. Sort User" + "\n" +
                    "6. Remove User" + "\n" +
                    "7. To end program.");

            System.out.println();
            System.out.print("Enter your choice:");

            userInput = input.nextLine();

            switch (userInput) {
                case "1":
                    addUser();
                    break;
                case "2":
                    viewAllUsers();
                    break;
                case "3":
                    findUser();
                    break;
                case "4":
                    updateUser();
                    break;
                case "5":
                    sortUserByName();
                    break;
                case "6":
                    deleteUser();
                    break;
                case "7":
                    System.out.println("Existing Phone Book.");
                    break;
                default:
                    break;
            }

        } while (!userInput.equalsIgnoreCase("7"));

        return;
    }

    public void addDefaultUsers() {
        phoneBook.addUser(new User(UUID.randomUUID(), "Inga", 371234567, "i@i.lv"));
        phoneBook.addUser(new User(UUID.randomUUID(), "Peteris", 371098765, "p@p.lv"));
        phoneBook.addUser(new User(UUID.randomUUID(), "Normund", 372345678, "n@n.lv"));
        phoneBook.addUser(new User(UUID.randomUUID(), "Irina", 371435465, "ir@ir.lv"));
        phoneBook.addUser(new User(UUID.randomUUID(), "Alex", 371678767, "a@a.lv"));
    }
    void addUser() {

        System.out.println("ADD NEW USER");

        User user = new User();

        System.out.print("Enter Name: ");
        user.name = input.nextLine();

        System.out.print("Enter Phone Number: ");
        user.phoneNumber = input.nextInt();
        input.nextLine();

        System.out.print("Enter e-mail: ");
        user.email = input.nextLine();

        user.id = UUID.randomUUID();

        String message = phoneBook.addUser(user);
        System.out.println(message + "\n");

    }

    void viewAllUsers() {
        ArrayList<User> allUsers = phoneBook.getAllUsers();

        System.out.println("ALL AVAILABLE USERS");
        System.out.println("Id\tUser name\t\tPhone Number\t\te-mail");

        int counter = 0;
        for (User user: allUsers) {
            System.out.println(counter + ".\t" + user.getFullInfo());
            counter++;
        }
        System.out.println();
    }

    void deleteUser() {
        System.out.println("DELETE USER");
        System.out.print("Enter User ID: ");

        int userId = Integer.parseInt(input.nextLine());

        String message;
        message = phoneBook.deleteUser(userId);
        System.out.println(message + "\n");

        viewAllUsers();
    }

    void sortUserByName() {
        System.out.println("SORT USER BY NAME");
        phoneBook.sortUsersByName();

        viewAllUsers();
    }

    void findUser() {
        System.out.println("FIND USER");
        System.out.print("Enter User Name or Part of User Name: ");

        String partOfName = input.nextLine();
        var foundUsers = phoneBook.findUser(partOfName);

        if(foundUsers.size() == 0) {
            System.out.println("No users found");
        }

        for (var user: foundUsers) {
            System.out.println(user.getFullInfo());
        }
        System.out.println();
    }

    void updateUser() {

        User user = new User();
        this.viewAllUsers();

        System.out.println("UPDATE USER CONTACT");

        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(input.nextLine());


        System.out.print("Enter new phone number: ");
        user.phoneNumber = input.nextInt();
        input.nextLine();

        System.out.print("Enter new e-mail: ");
        user.email = input.nextLine();

        String response = phoneBook.updateUser(userId, user);
        System.out.println(response + "\n");

    }
}
