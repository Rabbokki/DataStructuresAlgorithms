package arrayTest;

import java.util.Arrays;

public class ArrayExam03 {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 5, 3};
//        int m = 0;
        System.out.println("예 > " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            int m = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[m]){
                    m = j;
                }

            }
            int tmp = arr[m];
            arr[m] = arr[i];
            arr[i] = tmp;
            
            System.out.println(i +1 + "단계" + Arrays.toString(arr));

        }
    }
}
