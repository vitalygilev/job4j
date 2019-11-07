package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public static List<Integer> convert (List<int[]> list) {
        List<Integer> resList = new ArrayList<>();
        for (int[] curRow : list) {
            for (int curCell : curRow) {
                resList.add(curCell);
            }
        }
        return resList;
    }
}
