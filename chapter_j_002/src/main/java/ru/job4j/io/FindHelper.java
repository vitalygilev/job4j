package ru.job4j.io;

public class FindHelper {

    public static String getHelpText() {
        return "Possible options:\n"
                + "-d=Directory (searching directory)\n"
                + "-n=file name (mask or regular expression)\n"
                + "-m, -f, -r (searching mode - by mask, by certain filename of by regular expression - possible one of options!)\n"
                + "-o=Filename (Write results to file)\n"
                + "-h (Show help)\n";
    }

}
