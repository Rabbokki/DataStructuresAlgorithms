import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String l = "long ";

        for (int i = 0; i < n/4; i++) {
            if(n%4==0){
                System.out.printf(l);
            }
        }
        System.out.println("int");
    }
}
