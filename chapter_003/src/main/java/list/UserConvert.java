package list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public static HashMap<Integer, User> process(List<User> list) {

        HashMap<Integer, User> result = new HashMap<>();
        for (User curUser : list) {
            result.put(curUser.getId(), curUser);
        }
        return result;
    }

}
