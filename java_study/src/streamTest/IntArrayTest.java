package streamTest;

import java.util.Arrays;

public class IntArrayTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int sum = Arrays.stream(arr).sum();
        System.out.println(sum);
        long count = Arrays.stream(arr).count();
        System.out.println(count);


        for (int i : arr) {
            System.out.println(i);
        }
        Arrays.stream(arr).forEach(x-> System.out.println(x));
    }
}
