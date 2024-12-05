import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //주사위 세개의 값
//        int a = Integer.parseInt(br.readLine());
//        int b = Integer.parseInt(br.readLine());
//        int c = Integer.parseInt(br.readLine());
//
//        // 3. 눈이 모두 다른경우 (가장 큰눈) * 100
//        int max = 0;
//        if(a!=b && a!=c && b!=c){
//            if(a>b && a>c){
//                max = a;
//                System.out.println(max * 100);
//            }if(b>a && b>c){
//                max = b;
//                System.out.println(max * 100);
//            } else if (c > a && c > b) {
//                max = c;
//                System.out.println(max * 100);            }
//        }
//        // a=b a!=c
//        if(a==b){
//            System.out.println(1000 + a * 100);
//        }else if (b==c){
//            System.out.println(1000 + b * 100);
//        } else if (a==c) {
//            System.out.println(1000 + c * 100);
//        }else System.out.println(10000 + (a * 1000));

        Saboon sb = new Saboon();
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        sb.qudrantN(x,y);
    }
}