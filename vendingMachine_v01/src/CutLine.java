import java.util.*;

public class CutLine {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //입력수
        int n = sc.nextInt();
        int m = sc.nextInt();
//
//        //마지막에서 몇번째 인지
//        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int input = sc.nextInt();
            list.add(input);
        }
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list.get(m-1));


    }
}
