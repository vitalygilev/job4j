package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindSearcher {

    public static void search(FindFiles ff) throws IOException {
            if (ff.params.isShowHelp()) {
                FindOutput.outputString(FindHelper.getHelpText());
            } else {
                SearchFiles searcher = FindSearchFilesFactory.getSearcher(ff.params);
                if (searcher != null) {
                    Files.walkFileTree(Paths.get(ff.getDirectory()), searcher);
                    for (Path curPath : searcher.getPaths()) {
                        FindOutput.outputString(curPath.toFile().getPath());
                    }
                }
            }
    }
}
