package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindSearcher {

    public static void search(FindFiles ff) throws IOException {
        SearchFiles searcher = null;
        FindOutput.initiate(ff);
        if (FindValidator.valid(ff.params)) {
            if (ff.params.isShowHelp()) {
                FindOutput.outputString(FindHelper.getHelpText(), ff);
            } else {
                switch (ff.params.getSearchMode()) {
                    case 1:
                        ff.params.setNameRegularExpression(ff.params.getNameRegularExpression().replace("?", ".?").replace("*", ".*?"));
                    case 4:
                        searcher = new SearchFiles(p -> p.toFile().getName().matches(ff.params.getNameRegularExpression()));
                        break;
                    case 2:
                        searcher = new SearchFiles(p -> p.toFile().getName().equals(ff.params.getNameRegularExpression()));
                        break;
                    default:
                }
                if (searcher != null) {
                    Files.walkFileTree(Paths.get(ff.getDirectory()), searcher);
                    for (Path curPath : searcher.getPaths()) {
                        FindOutput.outputString(curPath.toFile().getPath(), ff);
                    }
                }
            }
        } else {
            FindOutput.outputString("Parameters are invalid: " + ff.params.getError() + "\n" + FindHelper.getHelpText(), ff);
        }
        System.out.println("Done!");
        FindOutput.closeFile(ff);
    }
}
