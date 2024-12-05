package arrayTest;

import java.util.Arrays;

public class ArrayExam05 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 4, 3};

        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j >0; j--) {

                //현재 값과 다음값을 비교 다음값이 크면 값을 바꿈
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }else {
                    break;
                }
            }
            System.out.println(i + " 단계 : " + Arrays.toString(arr));
        }

    }
}
