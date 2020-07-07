package ru.job4j.io;

public class FindSearchFilesFactory {

    public static SearchFiles getSearcher(FindParams params) {
        SearchFiles result = null;
        switch (params.getSearchMode()) {
            case 1:
                result = new SearchFilesByMask(params.getNameRegularExpression());
                break;
            case 2:
                result = new SearchFilesByName(params.getNameRegularExpression());
                break;
            case 4:
                result = new SearchFilesByRegularExpression(params.getNameRegularExpression());
                break;
            default:
        }
        return result;
    }
}
