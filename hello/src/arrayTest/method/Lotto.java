package arrayTest.method;

import java.util.Arrays;

public class Lotto {
    public static void main(String[] args) {
        int[] lottoNumber = new int[6];
        int[] myNumber = new int[6];

        int num = 0;
        int count = 0;

        LottoMethod l = new LottoMethod();
        l.lMethod(lottoNumber,count,num) ;
        l.lMethod(myNumber,count,num);

        System.out.println("로또 당첨 번호 : " + Arrays.toString(lottoNumber));
        System.out.println("내 번호 : " + Arrays.toString(myNumber));
        l.lottoCheck(lottoNumber,myNumber);

        if(Arrays.equals(lottoNumber,myNumber)){
            System.out.println("축! 당첨!");
        }else System.out.println("ㅋㅋㅋ");
    }


}
