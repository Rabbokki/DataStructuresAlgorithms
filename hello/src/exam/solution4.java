package exam;

import java.util.Scanner;

public class solution4 {
    public static void main(String[] args) {
        //문제4. n값까지의 합

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum+=i;
        }
        System.out.println(sum);

    }
}
