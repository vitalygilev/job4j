package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FindOutput {

    public static void initiate(FindFiles ff) throws FileNotFoundException {
        if (ff.params.getOutput() != null) {
            ff.params.setOutputFile(new PrintWriter(new BufferedOutputStream(new FileOutputStream(ff.params.getOutput()))));
        }
    }

    public static void outputString(String outString, FindFiles ff) {
        PrintWriter outputFile = ff.params.getOutputFile();
        if (outputFile == null) {
            System.out.println(outString);
        } else {
            outputFile.println(outString);
        }
    }

    public static void closeFile(FindFiles ff) {
        PrintWriter outputFile = ff.params.getOutputFile();
        if (outputFile != null) {
            outputFile.close();
        }
    }
}
