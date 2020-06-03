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

    private String removeLongComments(String content) {
        String tmpStr = content;
        int longCommentPosition = tmpStr.indexOf("/*");
        while (longCommentPosition != -1) {
            StringBuilder text = new StringBuilder();
            text.append(tmpStr, 0, longCommentPosition);
            int longCommentEndPosition = tmpStr.indexOf("*/");
            if (longCommentEndPosition != -1) {
                text.append(tmpStr.substring(longCommentEndPosition + 2));
            }
            tmpStr = text.toString();
            longCommentPosition = tmpStr.indexOf("/*");
        }
        return tmpStr;
    }

    public void load() {
        String[] curContent = removeLongComments(toString()).split(System.lineSeparator());
        for (String tmpStr : curContent) {
            String strKey = "";
            String strValue = "";
            int longCommentPosition = tmpStr.indexOf("//");
            if (longCommentPosition != -1) {
                tmpStr = tmpStr.substring(0, longCommentPosition);
            }
            int eqSignPosition = tmpStr.indexOf("=");
            if (eqSignPosition != -1) {
                strKey = tmpStr.substring(0, eqSignPosition).trim();
                strValue = tmpStr.substring(eqSignPosition + 1).trim();
            }
            if (!strKey.isEmpty()) {
                values.put(strKey, strValue);
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