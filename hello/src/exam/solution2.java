package exam;

public class solution2 {

    //문제2. 10부터 1까지 출력(3은 빼고)
    public static void main(String[] args) {
        //for문
        for (int i = 10; i >= 1 ; i--) {
            if(i==3)continue;

            System.out.println(i);
        }

        //while문
        int n = 10;
        while (n >= 1) {
            if (n==3) {
                n--;
                continue;
            }
            System.out.println(n);
            n--;
        }
    }
}
