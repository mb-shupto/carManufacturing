package oop.project.carmanufacturing;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = Arrays.asList(
            new User("Production Manager", "1234"),
            new User("QA Engineer", "5678")
    );

    // Check if username and password match any user
    public boolean validateLogin(String username, String password) {
        for (User user : users) {
            if (user.getUser().equals(username) &&
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Get all usernames for the dropdown
    public String[] getAllUsernames() {
        String[] usernames = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usernames[i] = users.get(i).getUser();
        }
        return usernames;
    }
}