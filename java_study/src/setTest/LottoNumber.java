package setTest;

import java.util.*;

public class LottoNumber {
    //로또 번호를 담는 Set 자료구조
    public static void main(String[] args) {
        Set<Integer> lotto = new HashSet<>();

        while (lotto.size() < 6){
            int num = ((int)(Math.random()*45))+1;
            lotto.add(num);
        }
        System.out.println(lotto);

        //리스트로 change
        List<Integer> lotto2 = new ArrayList<>(lotto);
        Collections.sort(lotto2);

        System.out.println(lotto2);

        Collections.sort(lotto2,Collections.reverseOrder());
        System.out.println(lotto2);

    }

}
