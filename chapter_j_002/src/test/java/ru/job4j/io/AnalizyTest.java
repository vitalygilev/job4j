package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {

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