package ru.job4j.search;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Depts {

    private Set<String> depts;

    public void addDept(String dept) {
        depts.add(dept);
        int slashPos = dept.lastIndexOf("\\");
        if (slashPos != -1) {
            addDept(dept.substring(0, slashPos));
        }
    }

    public Set<String> getDepts() {
        return depts;
    }

    public Depts(boolean directOrder) {
        if (directOrder) {
            depts = new TreeSet<>();
        } else {
            depts = new TreeSet<>(new Comparator<>() {
                @Override
                public int compare(String o1, String o2) {
                    return -o1.compareTo(o2);
                }
            });
        }
    }

    public static void main(String[] args) {
        Depts deptsStruc = new Depts(true);
        deptsStruc.addDept("K1\\SK1\\SSK1");
        System.out.println(deptsStruc.toString());
    }

}
