package arrayTest;

import java.util.Arrays;

public class ArrayExam08 {
    public static void main(String[] args) {
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 45 + 1);
        }
        System.out.println(Arrays.toString(arr));
        
    }

}
