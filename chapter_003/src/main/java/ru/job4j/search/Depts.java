package ru.job4j.search;

import java.util.*;

public class Depts {

    private Set<String> depts;

    public void fillGaps(List<String> orgs) {
        depts.addAll(orgs);
    }

    public void addDept(String dept) {
        List<String> orgs = new ArrayList<>();
        int slashPos;
        depts.add(dept);
        do {
            slashPos = dept.lastIndexOf("\\");
            if (slashPos != -1) {
                dept = dept.substring(0, slashPos);
                orgs.add(dept);
            } else {
                break;
            }
        } while (true);
        fillGaps(orgs);
    }

    public Set<String> getDepts() {
        return depts;
    }

    public Depts(boolean directOrder) {
        Comparator<String> comparator =
                directOrder ? Comparator.naturalOrder() : Comparator.reverseOrder();
        depts = new TreeSet<>(comparator);
    }

    @Override
    public String toString() {
        return "Depts{" +
                "depts=" + depts +
                '}';
    }

    public static void main(String[] args) {
        Depts deptsStruc = new Depts(true);
        deptsStruc.addDept("K1\\SK1");
        System.out.println(deptsStruc.toString());
    }

}
