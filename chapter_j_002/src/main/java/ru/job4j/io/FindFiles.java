package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FindFiles {

    private String directory = ".";
    private String nameRegularExpression;
    private int searchMode = 0;
    private String output;
    private String error = "";
    private PrintWriter outputFile = null;
    private boolean showHelp = false;

    private String getArgValue(String raw) {
        String res = "";
        int eqSignPos = raw.indexOf('=');
        if (eqSignPos != -1) {
            res = raw.substring(eqSignPos + 1).trim();
        }
        return res;
    }

    private void loadArgs(String[] args) {
        StringBuilder errorTest = new StringBuilder();
        for (String curArg : args) {
            if (curArg.contains("-d")) {
                directory = getArgValue(curArg);
            } else if (curArg.contains("-n")) {
                nameRegularExpression = getArgValue(curArg);
            } else if (curArg.contains("-h")) {
                showHelp = true;
            } else if (curArg.contains("-o")) {
                output = getArgValue(curArg);
            } else if (curArg.contains("-m")) {
                searchMode += 1;
            } else if (curArg.contains("-f")) {
                searchMode += 2;
            } else if (curArg.contains("-r")) {
                searchMode += 4;
            } else {
                errorTest.append(" unknown key '").append(curArg).append("'");
            }
            error = errorTest.toString();
        }
    }

    public FindFiles(String[] args) {
        loadArgs(args);
    }

    public String getDirectory() {
        return directory;
    }

    public String getNameRegularExpression() {
        return nameRegularExpression;
    }

    public int getSearchMode() {
        return searchMode;
    }

    public String getOutput() {
        return output;
    }

    public String getError() {
        return error;
    }

    public boolean valid() {
        StringBuilder errorTest = new StringBuilder();
        errorTest.append(error);
        if (directory.isEmpty()) {
            errorTest.append(" directory is'nt defined");
        }
        if (output != null && output.isEmpty()) {
            errorTest.append(" output is'nt defined");
        }
        if (nameRegularExpression != null && nameRegularExpression.isEmpty()) {
            errorTest.append(" regular expression is'nt defined");
        }
        if (((searchMode & 1) + ((searchMode >>> 1) & 1) + ((searchMode >>> 2) & 1)) > 1) {
            errorTest.append(" you can't combine -m, -f and -r (please choose one option!)");
        }
        error = errorTest.toString();
        return error.isEmpty();
    }

    public String getHelpText() {
        return "Possible options:\n"
                + "-d=Directory (searching directory)\n"
                + "-n=file name (mask or regular expression)\n"
                + "-m, -f, -r (searching mode - by mask, by certain filename of by regular expression - possible one of options!)\n"
                + "-o=Filename (Write results to file)\n"
                + "-h (Show help)\n";
    }

    public void outputString(String outString) {
        if (outputFile == null) {
            System.out.println(outString);
        } else {
            outputFile.println(outString);
        }
    }

    public static void main(String[] args) throws IOException {
        FindFiles ff = new FindFiles(args);
        SearchFiles searcher = null;
        if (ff.output != null) {
            ff.outputFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(ff.output)));
        }
        if (ff.valid()) {
            if (ff.showHelp) {
                ff.outputString(ff.getHelpText());
            } else {
                switch (ff.searchMode) {
                    case 1:
                        ff.nameRegularExpression = ff.nameRegularExpression.replace("?", ".?").replace("*", ".*?");
                    case 4:
                        searcher = new SearchFiles(p -> p.toFile().getName().matches(ff.nameRegularExpression));
                        break;
                    case 2:
                        searcher = new SearchFiles(p -> p.toFile().getName().equals(ff.nameRegularExpression));
                        break;
                    default:
                }
                if (searcher != null) {
                    Files.walkFileTree(Paths.get(ff.getDirectory()), searcher);
                    searcher.getPaths().stream().map(line -> line.toFile().getPath()).forEach(ff::outputString);
                }
            }
        } else {
            ff.outputString("Parameters are invalid: " + ff.getError() + "\n" + ff.getHelpText());
        }
        System.out.println("Done!");
        if (ff.outputFile != null) {
            ff.outputFile.close();
        }
    }

}
