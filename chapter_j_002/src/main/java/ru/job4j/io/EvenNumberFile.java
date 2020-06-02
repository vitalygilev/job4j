package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {

    public static String isEven(String value) {
        String res;
        try {
            res = Integer.parseInt(value) % 2 == 0 ? "even" : "odd";
        } catch (Exception ex) {
            res = "unable to define (" + ex.getMessage() + ")";
        }
        return res;
    }

    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println("The number of " +  line + " is " + isEven(line) + ".");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
