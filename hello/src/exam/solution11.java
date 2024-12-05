package exam;

import java.util.Scanner;

public class solution11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();

        if(p>=90){
            System.out.println("A");
        } else if (p>=80) {
            System.out.println("B");
        }else if (p>=70) {
            System.out.println("C");
        }else if (p>=60) {
            System.out.println("D");
        }else System.out.println("F");
    }
}
