package exam;

import java.util.Scanner;

public class solution13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int ct = sc.nextInt();
        int t;

        t = h*60+m+ct;
        h = t/60;
        m = t%60;

        if(h>=24){
            h = (h-24);
        }

        System.out.println(h + " " + m);


    }
}
