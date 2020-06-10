package ru.job4j.io;

public class ArgZip {

    private final String[] args;
    private String directory = "";
    private String exclude = "";
    private String output = "";
    private String error = "";

    private String getArgValue(String raw) {
        String res = "";
        int eqSignPos = raw.indexOf('=');
        if (eqSignPos != -1) {
            res = raw.substring(eqSignPos + 1).trim();
        }
        return res;
    }

    private void loadArgs() {
        for (String curArg : args) {
            if (curArg.contains("-d") || curArg.contains("-directory")) {
                directory = getArgValue(curArg);
            } else
            if (curArg.contains("-e") || curArg.contains("-exclude")) {
                exclude = getArgValue(curArg);
            } else
            if (curArg.contains("-o") || curArg.contains("-output")) {
                output = getArgValue(curArg);
            }
        }
    }

    public ArgZip(String[] args) {
        this.args = args;
        loadArgs();
    }

    public boolean valid() {
        boolean res = true;
        StringBuilder errorTest = new StringBuilder();
        if (directory.isEmpty()) {
            errorTest.append(" directory not defined");
            res = false;
        }
        if (exclude.isEmpty()) {
            errorTest.append(" exclude not defined");
            res = false;
        }
        if (output.isEmpty()) {
            errorTest.append(" output not defined");
            res = false;
        }
        error = errorTest.toString();
        return res;
    }

    public String directory() {
        return directory;
    }

    public String exclude() {
        return exclude;
    }

    public String output() {
        return output;
    }

    public String getError() {
        return error;
    }

}
