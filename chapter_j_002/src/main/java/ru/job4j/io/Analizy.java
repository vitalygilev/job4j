package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
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

    public void unavailable(String source, String target) {
        String[] sourceContent = loadSourceFile(source);
        String startTime = "";
        String endTime = "";
        Set<String> errorTypes = Stream.of("400", "500").collect(Collectors.toSet());
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
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
                        out.println(startTime + ";" + endTime);
                        startTime = "";
                        endTime = "";
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
