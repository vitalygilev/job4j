package ru.job4j.generic;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {

        Map<Integer, User> tmpUsers = previous.stream().collect(Collectors.toMap(User::getId, item -> item));
        Info res = new Info();
        User curBaseUser;

        for (User curUser : current) {
            int curId = curUser.getId();
            curBaseUser = tmpUsers.get(curId);
            if (curBaseUser == null) {
                res.added++;
            } else {
                if (!curUser.equals(curBaseUser)) {
                    res.changed++;
                }
                tmpUsers.remove(curId);
            }
        }
        res.deleted = tmpUsers.size();
        return res;
    }

    public static class User {
        int id;
        String name;
        public int getId() {
            return id;
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info() {
        }

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }



}
