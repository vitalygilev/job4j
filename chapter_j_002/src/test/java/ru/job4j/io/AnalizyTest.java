package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenThereIsACaseOfFailureTempFolder() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analizy cerAnalyser = new Analizy();
        cerAnalyser.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        Assert.assertThat(rsl.toString(), is("10:57:01;10:58:01"));
    }

    @Test
    public void whenThereIsACaseOfFailure() {
        Analizy cerAnalyser = new Analizy();
        cerAnalyser.unavailable("./data/servlog.log", "./data/unavailable.csv");
        String[] unavailableContent = cerAnalyser.loadSourceFile("./data/unavailable.csv");
        assertThat(
                unavailableContent[0],
                is("10:57:01;10:58:01")
        );
    }

}