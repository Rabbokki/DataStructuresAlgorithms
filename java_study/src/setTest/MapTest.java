package setTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String,Integer> store = new HashMap<>();
        store.put("water",1);
        store.put("fruit",2);
        store.put("fruit",3);
        store.put("my",1);

        store.remove("my");


        for (String s : store.keySet()) {
            System.out.println(s + " : "+store.get(s));
        }
    }
}
