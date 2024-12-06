import java.util.*;

public class ListEx {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        List<Integer> i = new ArrayList<>();


        i.add(10);
        i.add(11);
        i.add(12);
        i.add(13);

        for (int in : i){
            System.out.println(i.size());
        }


        l.add("떡볶이");
        l.add("라볶이");
        l.add("군만두");
        l.add("탕수육");
        l.add("치즈라볶이");

//        for (int i = 0; i < l.size(); i++) {
//            System.out.println(l.get(i));
//        }
        for(String s : l){
            System.out.println(s);
        }
    }
}
