package phonebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhoneBook {

    private ArrayList<User> users = new ArrayList<User>();

    public String addUser(User user){
        this.users.add(user);
        return user.name + " added successfully";
    }

    public ArrayList<User> getAllUsers(){
        return users;
    }

    public String deleteUser(int userId){
        try {
            users.remove(userId);
        } catch (Exception ex){
            return "Unable to remove specified user";
        }
        return "Contact " + userId + " removed successfully";
    }

    public void sortUsersByName(){

        Collections.sort(users, Comparator.comparing(user -> user.name));
    }

    public ArrayList<User> findUser(String userName){

        ArrayList<User> foundUsers = new ArrayList<>();

        for (User user : users) {
             if(user.name.contains(userName)) {
                 foundUsers.add(user);
             }
        }
        return foundUsers;
    }

    public String updateUser(int userId, User newUser){
        if(this.users.get(userId) != null) {
            User oldUser = this.users.get(userId);
            newUser.name = oldUser.name;
            oldUser.phoneNumber = newUser.phoneNumber;
            oldUser.email = oldUser.email;
            return "Contact " + userId +  " update successfully";

        }
        return "User not found";

    }
}
