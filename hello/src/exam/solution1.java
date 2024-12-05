package exam;

public class solution1 {
    public static void main(String[] args) {
        //문제1. 1부터 10까지 수 출력(6은 빼고)

        //for문
        for (int i = 1; i <= 10; i++) {
            if(i==6){
                continue;
            }
            System.out.println(i);
        }

        //while문
        int n = 1;
        while (n<=10) {

            if(n==6){
                n++;
                continue;

            }
            System.out.println(n);
            n++;
        }
    }
}
