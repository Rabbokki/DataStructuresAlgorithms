package arrayTest.method;

public class LottoMethod {
    public int[] lMethod(int[]numbers, int count, int num){
        while (count < 6){
            num = (int)(Math.random()*45)+1;

            //중복번호 확인
            boolean flag = false;

            for (int i = 0; i < count; i++) {
                if(numbers[i] == num){
                    flag =true;
                    break;
                }
            }
            if(flag==false){
                numbers[count] = num;
                count++;
            }
        }
        return numbers;
    }
    public static void lottoCheck(int[] lottoNumber,int[] myNumber) {
        //몇개 당첨됬는지 확인하는 변수
        int cnt = 0;
        //밖에 for는 내 번호를 하나씩 비교하는 용도
        for (int i = 0; i < lottoNumber.length; i++) {

            //당첨번호를 전부 다 비교해서 맞는지 용도
            for (int j = 0; j < lottoNumber.length; j++) {
                if(myNumber[i] == lottoNumber[j]){
                    System.out.println("당첨번호 : " + myNumber[i]);
                    cnt++;
                }
            }
        }
        System.out.println("맞은 개수 : " + cnt);
    }
}
