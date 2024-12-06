import java.util.LinkedList;
import java.util.List;

public class ListEx02 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);

        for (int li : list){
            System.out.println(list.size());
        }
    }
}
