import java.util.Scanner;

public class NumbersSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int[] a = new int[n-1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sum+=a[i];
        }
        System.out.println(sum);
    }
}
