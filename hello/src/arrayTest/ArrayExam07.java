package arrayTest;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExam07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] randomNumber = new int[3];
        int[] myNumber = new int[3];
        int strike = 0;
        int ball = 0;

        //랜덤넘버에 랜덤숫자 대입, 마이넘버에 입력숫자 대입
        for (int i = 0; i <randomNumber.length ; i++) {
            randomNumber[i] = (int)(Math.random()*10);
            myNumber[i] = sc.nextInt();
        }
        int idx = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                if(randomNumber[i]==myNumber[j]){
                    idx++;
                    strike++;
                }

            }
        }

        //랜덤 숫자와 입력숫자 출력확인
        System.out.println(Arrays.toString(randomNumber));
        System.out.println(Arrays.toString(myNumber));
    }
}
