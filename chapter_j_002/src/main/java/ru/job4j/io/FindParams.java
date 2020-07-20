package ru.job4j.io;

import java.io.File;

public class FindParams {

    private final String[] args;
    char[] keys = {'d', 'n', 'o', 'm', 'f', 'r'};
    int[] indexes = {-1, -1, -1, -1, -1, -1};

    public FindParams(String[] args) {
        this.args = args;
    }

    private int getKeyIndex(char keyLetter) {
        int result = -1;
        for (int i = 0; i <= keys.length; i++) {
            if (keys[i] == keyLetter) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void validate() throws IllegalArgumentException {
        if (args.length != 7) {
            throw new IllegalArgumentException("Invalid args count! Try again, e.g. java -jar find.jar -d c:/ -n *.txt -m -o log.txt");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].charAt(0) != '-') {
                throw new IllegalArgumentException("Args must be started with -");
            }
            char keyLetter = args[i].charAt(1);
            int keyIndex = getKeyIndex(keyLetter);
            if (keyIndex == -1) {
                throw new IllegalArgumentException("Wrong arg name " + keyLetter);
            }
            if (keyIndex < 3) {
                indexes[keyIndex] = ++i;
            } else {
                indexes[keyIndex] = 0;
            }
        }
        if (indexes[3] + indexes[4] + indexes[5] != -2) {
            throw new IllegalArgumentException("You must choose one of -m, -f or -r");
        }
        File dir = new File(args[indexes[0]]);
        if (!dir.exists()) {
            throw new IllegalArgumentException("Search directory is not exist!");
        }
    }

    public String getDirectory() {
        return args[indexes[0]];
    }

    public String getNameRegularExpression() {
        return args[indexes[1]];
    }

    public int getSearchMode() {
        return (indexes[3] + 1) + (indexes[4] + 1) * 2 + (indexes[5] + 1) * 4;
    }

    public String getOutput() {
        return args[indexes[2]];
    }

}
