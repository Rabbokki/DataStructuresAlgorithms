package algorithem;

import java.util.Arrays;
import java.util.Scanner;

public class 커트라인 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int cut = arr[arr.length-K];

        System.out.println(cut);

    }
}
