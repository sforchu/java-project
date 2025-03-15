package db;

import java.util.HashMap;
import java.util.Map;

public class FakeDB {
    public static Map<String, String> USER_DB = new HashMap<>();

    static {
        USER_DB.put("Eddy", "eddy123");
        USER_DB.put("Smith", "saf123");
        USER_DB.put("Didi", "didi123");
    }
}
