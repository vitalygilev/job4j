package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analizy {

    public String[] loadSourceFile(String source) {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString().split(System.lineSeparator());
    }

    private static void writeToFile(String target, List<String> content) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (String curString : content) {
                out.println(curString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unavailable(String source, String target) {
        String[] sourceContent = loadSourceFile(source);
        ArrayList<String> targetContent = new ArrayList<>();
        String startTime = "";
        String endTime = "";
        Set<String> errorTypes = Stream.of("400", "500").collect(Collectors.toSet());
        for (String curSourceString : sourceContent) {
            String[] recordStruct = curSourceString.split(" ");
            if (errorTypes.contains(recordStruct[0])) {
                if (startTime.isEmpty()) {
                    startTime = recordStruct[1];
                } else {
                    endTime = recordStruct[1];
                }
            } else {
                if (!startTime.isEmpty() && !endTime.isEmpty()) {
                    targetContent.add(startTime + ";" + endTime);
                    startTime = "";
                    endTime = "";
                }
            }
        }
        writeToFile(target, targetContent);
    }

    public static void main(String[] args) {
        writeToFile("unavailable.csv", Arrays.asList("15:01:30;15:02:32", "15:10:30;23:12:32"));
    }
}
