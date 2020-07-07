package ru.job4j.io;

import java.io.IOException;

public class FindFiles {

    FindParams params = new FindParams();

    public FindFiles(String[] args) {
        FindParamsParser.loadArgs(args, params);
    }

    public String getDirectory() {
        return params.getDirectory();
    }

    public String getError() {
        return params.getError();
    }

    public static void main(String[] args) throws IOException {
        FindFiles ff = new FindFiles(args);
        if (FindValidator.valid(ff.params)) {
            FindSearcher.search(ff);
        } else {
            FindOutput.outputString("Parameters are invalid: " + ff.params.getError() + "\n" + FindHelper.getHelpText());
        }
        FindOutput.closeSearch(ff);
        System.out.println("Done!");
    }

}
