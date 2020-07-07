package ru.job4j.io;

import java.util.HashMap;

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
        HashMap<String, String> tempParams = new HashMap<>();
        for (String curArg : args) {
            tempParams.put(curArg.substring(0, 2), getArgValue(curArg));
        }
        String tmpArg;
        tmpArg = tempParams.get("-d");
        if (tmpArg != null) {
            params.setDirectory(tmpArg);
            tempParams.remove("-d");
        }
        tmpArg = tempParams.get("-n");
        if (tmpArg != null) {
            params.setNameRegularExpression(tmpArg);
            tempParams.remove("-n");
        }
        tmpArg = tempParams.get("-h");
        if (tmpArg != null) {
            params.setShowHelp(true);
            tempParams.remove("-h");
        }
        tmpArg = tempParams.get("-o");
        if (tmpArg != null) {
            params.setOutput(tmpArg);
            tempParams.remove("-o");
        }
        tmpArg = tempParams.get("-m");
        if (tmpArg != null) {
            params.setSearchMode(params.getSearchMode() + 1);
            tempParams.remove("-m");
        }
        tmpArg = tempParams.get("-f");
        if (tmpArg != null) {
            params.setSearchMode(params.getSearchMode() + 2);
            tempParams.remove("-f");
        }
        tmpArg = tempParams.get("-r");
        if (tmpArg != null) {
            params.setSearchMode(params.getSearchMode() + 4);
            tempParams.remove("-r");
        }
        for (String curKey : tempParams.keySet()) {
            errorTest.append(" unknown key '").append(curKey).append("'");
        }
            params.setError(errorTest.toString());
    }

}
