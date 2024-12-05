import java.util.Arrays;
import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int max = 0;
        int count=0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
                count++;
            }
        }
        System.out.println(max);
        System.out.println(count-1);
    }
}
