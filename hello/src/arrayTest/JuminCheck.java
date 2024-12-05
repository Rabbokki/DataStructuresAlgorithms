package arrayTest;

public class JuminCheck {
    public static void main(String[] args) {
        int[] jumin = {1,4,0,4,1,6,4,1,4,0,8,1};
        int[] jari =  {2,3,4,5,6,7,8,9,2,3,4,5};
        int[] gob = new int[12];
        int sum=0;

//        for (int i = 0; i < jumin.length; i++) {
//            for (int j = 0; j <= i; j++) {
//                gob[i] = jumin[i] * jari[i];
//            }
//            System.out.println(gob[i]);
//        }
        for (int i = 0; i < jumin.length; i++) {
            gob[i] = jumin[i]*jari[i];
            System.out.println(gob[i]);
            sum += gob[i];
        }
//        for (int i = 0; i < gob.length; i++) {
//            sum += gob[i];
//        }
        System.out.println("모두 더함"+sum);
        sum = sum%11;
        System.out.println(sum);
        sum = 11-sum;
        System.out.println(sum);
    }
}
