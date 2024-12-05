package arrayTest;

import java.util.Arrays;

public class ArrayExam04 {
    public static void main(String[] args) {
        int[] arr = {9, 8, 2, 4, 3};
        boolean flag = false;
        int index = 0;

        for (int i = 0; i < arr.length-1 ; i++) {

            for (int j = 0; j < arr.length -i -1; j++) {

                if(arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = true;
                }
            }
            //바뀜이 일어났는지 체크
            if(flag==false){
                break;
            }else {
                System.out.println(i +1 + "단계" + Arrays.toString(arr));
                flag = false;
            }

        }
    }
}
