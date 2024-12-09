import java.util.Scanner;

public class Sangsoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int reverse1 = 0;
        int reverse2 = 0;

        while (num1 != 0){
            int digit1 = num1 % 10;
            int digit2 = num2 % 10;

            reverse1 = reverse1 * 10 + digit1;
            reverse2 = reverse2 * 10 + digit2;
            num1 /= 10;
            num2 /= 10;
        }
        if(reverse1>reverse2){
            System.out.println(reverse1);
        }else System.out.println(reverse2);



    }
}
