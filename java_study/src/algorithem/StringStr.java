package algorithem;

import java.util.Scanner;

public class StringStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tCase = sc.nextInt();
        sc.nextLine();
//        String str = sc.nextLine();
//        String s = str.substring(0);
//        System.out.println(s+s);
        for (int i = 0; i < tCase; i++) {
            String str = sc.nextLine();
            if(str.length()==1){
                String s = str.substring(0);
                System.out.println(s+s);
            } else if (str.length()==2) {
                String s = str.substring(0,2);
                System.out.println(s);
            }

            System.out.println(str.substring(0,1) + str.substring(str.length()-1));
        }
    }
}
