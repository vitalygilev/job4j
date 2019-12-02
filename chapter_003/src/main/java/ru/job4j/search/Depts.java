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
        Comparator<String> comparator =
                directOrder ? Comparator.naturalOrder() : Comparator.reverseOrder();
        depts = new TreeSet<>(comparator);
    }

    public static void main(String[] args) {
        Depts deptsStruc = new Depts(true);
        deptsStruc.addDept("K1\\SK1\\SSK1");
        System.out.println(deptsStruc.toString());
    }

}
