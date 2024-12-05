import java.util.Scanner;

public class Xmin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[a];

        for (int i = 0; i < arr.length; i++) {
            arr[i] += sc.nextInt();
            if(arr[i]<x){
                System.out.print(arr[i]);
            }
        }
    }
}
