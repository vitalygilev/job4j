package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Chat {

    private static List<String> answersContent;

    private static void loadFileWithAnswers(String source) {
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            answersContent = in.lines().collect(Collectors.toList());
            System.out.println(answersContent.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processLine(String prompt, boolean silentMode, PrintWriter logFile) {
        if (!silentMode) {
            System.out.println(prompt);
            logFile.println("Bot: " + prompt);
        }
        Scanner scan = new Scanner(System.in);
        String userAnswer = scan.nextLine();
        logFile.println("User:" + userAnswer);
        return userAnswer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        loadFileWithAnswers("./chapter_j_002/data/answers.txt");
        try (PrintWriter logFile = new PrintWriter(new FileOutputStream("./chapter_j_002/data/chat_log.txt"))) {
            boolean silentMode = false;
            String userAsk = "";
            String prompt = "Welcome to chat! Say something please!";
            while (!userAsk.toLowerCase().contains("закончить")) {
                userAsk = processLine(prompt, silentMode, logFile);
                silentMode = !silentMode ? userAsk.toLowerCase().contains("стоп") : !userAsk.toLowerCase().contains("продолжить");
                if (!silentMode) {
                    prompt = answersContent.get((int) (Math.random() * answersContent.size()));
                }
            }
        }
    }
}
