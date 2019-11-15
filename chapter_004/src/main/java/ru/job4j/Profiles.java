package ru.job4j;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public static List<Address> collect(List<Profile> profiles) {
        return profiles
                .stream()
                .distinct()
                .map(Profile::getAddress)
                .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()))
                .collect(Collectors.toList());
    }

}
