package algorithem;

import java.util.Scanner;

public class StringPlus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
            String[] s = str.split("");
            int sum = 0;

            for (int i = 0; i < s.length; i++) {
                int num = Integer.parseInt(s[i]);
                sum+=num;
            }
            System.out.println(sum);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
