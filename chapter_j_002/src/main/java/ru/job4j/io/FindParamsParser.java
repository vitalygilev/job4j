package ru.job4j.io;

public class FindParamsParser {

    private static String getArgValue(String raw) {
        String res = "";
        int eqSignPos = raw.indexOf('=');
        if (eqSignPos != -1) {
            res = raw.substring(eqSignPos + 1).trim();
        }
        return res;
    }

    public static void loadArgs(String[] args, FindParams params) {
        StringBuilder errorTest = new StringBuilder();
        for (String curArg : args) {
            if (curArg.contains("-d")) {
                params.setDirectory(getArgValue(curArg));
            } else if (curArg.contains("-n")) {
                params.setNameRegularExpression(getArgValue(curArg));
            } else if (curArg.contains("-h")) {
                params.setShowHelp(true);
            } else if (curArg.contains("-o")) {
                params.setOutput(getArgValue(curArg));
            } else if (curArg.contains("-m")) {
                params.setSearchMode(params.getSearchMode() + 1);
            } else if (curArg.contains("-f")) {
                params.setSearchMode(params.getSearchMode() + 2);
            } else if (curArg.contains("-r")) {
                params.setSearchMode(params.getSearchMode() + 4);
            } else {
                errorTest.append(" unknown key '").append(curArg).append("'");
            }
            params.setError(errorTest.toString());
        }
    }

}
