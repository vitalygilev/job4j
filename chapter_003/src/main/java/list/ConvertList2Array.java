package list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int) Math.ceil((double)list.size() / rows);
        int[][] array = new int[rows][cells];
        int curPos = 0;
        for (Integer currentInt : list) {
            array[curPos / rows][curPos % rows] = currentInt;
            curPos++;
        }
        return array;
    }
}
