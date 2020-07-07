package ru.job4j.io;

public class FindParams {

    private String directory = ".";
    private String nameRegularExpression;
    private int searchMode = 0;
    private String output;
    private String error = "";
    private boolean showHelp = false;

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getNameRegularExpression() {
        return nameRegularExpression;
    }

    public void setNameRegularExpression(String nameRegularExpression) {
        this.nameRegularExpression = nameRegularExpression;
    }

    public int getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(int searchMode) {
        this.searchMode = searchMode;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public void setShowHelp(boolean showHelp) {
        this.showHelp = showHelp;
    }
}
