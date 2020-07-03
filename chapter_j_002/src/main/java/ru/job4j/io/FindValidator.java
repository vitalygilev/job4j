package ru.job4j.io;

public class FindValidator {

    public static boolean valid(FindParams params) {
        StringBuilder errorTest = new StringBuilder();
        errorTest.append(params.getError());
        if (params.getDirectory().isEmpty()) {
            errorTest.append(" directory is'nt defined");
        }
        if (params.getOutput() != null && params.getOutput().isEmpty()) {
            errorTest.append(" output is'nt defined");
        }
        if (params.getNameRegularExpression() != null && params.getNameRegularExpression().isEmpty()) {
            errorTest.append(" regular expression is'nt defined");
        }
        if (((params.getSearchMode() & 1) + ((params.getSearchMode() >>> 1) & 1) + ((params.getSearchMode() >>> 2) & 1)) > 1) {
            errorTest.append(" you can't combine -m, -f and -r (please choose one option!)");
        }
        params.setError(errorTest.toString());
        return params.getError().isEmpty();
    }

}
