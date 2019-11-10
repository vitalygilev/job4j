package list;

import java.util.Comparator;

public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = 0;
        int curCharCompare = 0;
        while (i < left.length() && i < right.length()) {
            curCharCompare = Character.compare(left.charAt(i), right.charAt(i));
            if (curCharCompare != 0) {
                break;
            }
            i++;
        }
        return curCharCompare == 0 ? left.length() - right.length() : curCharCompare;
    }
}
