package algorithem;

import java.util.Arrays;
import java.util.Scanner;

public class 대표값2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int avg = 0;
        int mid = 0;
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            avg = sum / 5;
        }
        Arrays.sort(arr);
        mid = arr[arr.length/2];
        System.out.println(mid);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
        System.out.println(avg);
    }
}
