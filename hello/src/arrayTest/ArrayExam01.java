package arrayTest;

public class ArrayExam01 {
    public static void main(String[] args) {
        int[] arr = {3, 29, 38, 12, 57, 74, 40, 85, 95,101,61};
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
                cnt = i+1;
            }
        }
        System.out.println(max);
        System.out.print(cnt);

    }
}
