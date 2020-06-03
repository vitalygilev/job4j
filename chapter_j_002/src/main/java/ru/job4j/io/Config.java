package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        String[] curContent = toString().split(System.lineSeparator());
        for (String tmpStr : curContent) {
            int eqSignPosition = tmpStr.indexOf("=");
            if (!tmpStr.contains("#") && eqSignPosition != -1) {
                String strKey = tmpStr.substring(0, eqSignPosition).trim();
                if (!strKey.isEmpty()) {
                    values.put(strKey, tmpStr.substring(eqSignPosition + 1).trim());
                }
            }
        }
    }

    public String value(String key) {
        String res = values.get(key);
        return res == null ? "" : res;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}