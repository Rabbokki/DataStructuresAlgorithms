package arrayTest;

import java.util.Arrays;

public class ArrayExam02 {
    public static void main(String[] args) {
        int dice1 = 0;
        int dice2 = 0;
        int diceSum = 0;
        int[] dice = new int[11];

        for (int i = 1; i <=36000; i++) {
            dice1 = ((int)(Math.random()*6)) + 1;
            dice2 = ((int)(Math.random()*6)) + 1;
            diceSum = dice1 + dice2;
//            dice[diceSum-2] = dice[diceSum-2] +1;
            dice[diceSum-2]++;
        }

        System.out.println("Output : ");
        double rate = 0.0;

        for (int i = 0; i < dice.length; i++) {
            rate = (double) dice[i]/36000;
            System.out.println((i+2) + ":" + dice1 + " ( " +
                    rate + ")");
        }
//        for (int i = 0; i < 36000; i++) {
//            result[i] = dice1[i] + dice2[i];
//        }


//        System.out.println(Arrays.toString(diceSum));
    }
}
