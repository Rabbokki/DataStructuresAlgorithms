import java.util.Scanner;

public class GlobalPonix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String s1 = sc.next();
//        String s2 = sc.next();
//        String s3 = sc.next();
//
//        for (int u = 0; u < 3; u++) {
//            if(s1.charAt(0) == 105 || s1.charAt(0) == 107 || s1.charAt(0) == 112){
//                System.out.println("GLOBAL");
//                if(s2.charAt(0) == 105 || s2.charAt(0) == 107 || s2.charAt(0) == 112){
//                    System.out.println("GLOBAL");
//                }if(s3.charAt(0) == 105 || s3.charAt(0) == 107 || s3.charAt(0) == 112){
//                    System.out.println("GLOBAL");
//                }
//                break;
//            }
//            else {
//                System.out.println("PONIX");
//                break;
//            }
//        }
        int l = 0;
        int k = 0;
        int p = 0;

        for (int i = 0; i < 3; i++) {
            String s = sc.next();

            if(s.charAt(0)=='l'){
                l = 1;
            } else if (s.charAt(0)=='k') {
                k = 1;
            } else if (s.charAt(0)=='p') {
                p=1;
            }
        }
        if(l==1 && k==1 && p==1){
            System.out.println("GLOBAL");
        }else System.out.println("PONIEX");

    }
}
