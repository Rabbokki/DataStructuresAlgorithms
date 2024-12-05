import java.util.Scanner;

public class WordNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String s = " ";
        int cnt = 0;
        if (str.equals(s)){
            cnt++;
        }
        System.out.println(cnt);
    }

}
