package oop.project.carmanufacturing;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> userList = new ArrayList<>();;

    public UserManager() {
        if (userList.isEmpty()) {
            userList.add(new User("Production Manager", "1234"));
            userList.add(new User("QA Engineer", "1234"));
        }
    }

    public List<User> getUserList() {
        return userList;
    }
}
