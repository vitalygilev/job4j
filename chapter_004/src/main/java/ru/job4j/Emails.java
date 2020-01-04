package ru.job4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Emails {

    Map<String, Set<String>> emails;

    public Emails() {
        emails = new HashMap<>();
    }

    public Map<String, Set<String>> getEmails() {
        return emails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Emails)) return false;
        Emails emails = (Emails) o;
        return getEmails().equals(emails.getEmails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmails());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        var allUsers = emails.keySet().toArray();
        for (Object allUser : allUsers) {
            String tmpString = emails.get(allUser).toString();
            result.append(allUser).append("->").append(tmpString, 1, tmpString.length() - 1).append("\n");
        }
        return result.toString();
    }
}
