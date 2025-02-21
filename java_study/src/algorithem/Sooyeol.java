package algorithem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sooyeol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
//        sc.nextLine();
        int x = sc.nextInt();
        List<Integer> min = new ArrayList<>();
        int[] a = new int[n];

        for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i] < x){
                min.add(a[i]);
            }
        }
        for (int i = 0; i < min.size(); i++) {
            System.out.print(min.get(i)+ " ");
        }
//        System.out.println();
    }
}
