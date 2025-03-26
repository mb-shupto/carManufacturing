package oop.project.carmanufacturing;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<User> userList = new ArrayList<>();;

    public UserManager() {
        if (userList.isEmpty()) {
            userList.add(new User("asif", "1234", 50));
            userList.add(new User("test", "1234", 20));
            userList.add(new User("admin", "1234", 30));
            userList.add(new User("cis101", "cis101", 100));
        }
    }

    public List<User> getUserList() {
        return userList;
    }
}
