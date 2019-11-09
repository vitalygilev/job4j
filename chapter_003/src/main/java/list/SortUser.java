package list;

import java.util.*;

public class SortUser {

    public static void main(String[] args) {
        Set<User> users = new TreeSet<>();
        users.addAll(
                Arrays.asList(
                        new User(1, "User 1", "Default city", 20),
                        new User(2, "User 2", "Default city", 34),
                        new User(3, "User 3", "Default city", 56),
                        new User(4, "User 4", "Default city", 17)
                )
        );
        System.out.println(users);
    }

}
