package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;

public class FindOutput {

    private static LinkedList<String> outputLog = new LinkedList<>();

    public static void outputString(String outString) {
        outputLog.add(outString);
    }

    public static void closeSearch(FindFiles ff) throws FileNotFoundException {
        if (ff.params.getOutput() != null) {
            PrintWriter outputFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(ff.params.getOutput())));
            outputLog.forEach(outputFile::println);
            outputFile.close();
        } else {
            outputLog.forEach(System.out::println);
        }
    }
}
