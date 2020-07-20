package ru.job4j.io;

import java.io.IOException;

public class FindFiles {

    public FindParams params;

    public FindFiles(String[] args) {
        params = new FindParams(args);
    }

    public static void main(String[] args) throws IOException {
        FindFiles ff = new FindFiles(args);
        try {
            ff.params.validate();
            FindSearcher.search(ff);
            FindOutput.closeSearch(ff);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Done!");
    }

}
