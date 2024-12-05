package exam;

import java.util.Scanner;

public class solution6 {
    //문제6 두 정수 입력 받고 두 정수 합을 출력
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + " + " + b + " = " + (a+b));
    }
}
