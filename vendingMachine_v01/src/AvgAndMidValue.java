import java.util.Arrays;
import java.util.Scanner;

public class AvgAndMidValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int avg = 0;

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        avg = sum / arr.length;

        System.out.println(avg);
        System.out.println(arr[arr.length/2]);
    }
}
