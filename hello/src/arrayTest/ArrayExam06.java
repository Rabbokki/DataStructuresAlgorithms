package arrayTest;

public class ArrayExam06 {
    public static void main(String[] args) {
        int[] a = {85, 50, 90, 75, 85, 60, 89, 98, 83, 65};
        int[] r = new int[10];

        for (int i = 0; i < a.length; i++) {
            int idx = 1;
            for (int j = 0; j < a.length; j++) {
                if(a[j] > a[i]){
                    idx++;
                }
            }
            r[i] = idx;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println("점수 : " + a[i]);
            System.out.println("등수 : " + r[i]+"\n");

        }
    }
}
