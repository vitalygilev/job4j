package list;

import java.util.*;

public class SortUser {

    public static  List<User> sortNameLength(List<User> users) {
        users.sort(
                new Comparator<>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().length() - o2.getName().length();
                    }
                }
        );
        return users;
    }

    public static List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int prevRes = o1.getName().compareTo(o2.getName());
                        return prevRes == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : prevRes;
                    }
                }
        );
        return users;
    }

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
