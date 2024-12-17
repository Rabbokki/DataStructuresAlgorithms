package streamTest;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class ReduceTest {
    public static void main(String[] args) {
        String[] greetings = {"안녕하세요" ,"Hello","Good morning","반갑습니다."};
        String reslut;

        //람다식으로 reduce 구현하기
        reslut = Arrays.stream(greetings).reduce("",(str1,str2)->{
           if (str1.length() >= str2.length()){
               return str1;
           }else{
               return str2;
           }
        });
        System.out.println(reslut);

        //BinaryOperator를 이용해서 reduce() 구현하기
        reslut = Arrays.stream(greetings).reduce(new CompareString()).get();
        System.out.println(reslut);
    }
}
class CompareString implements BinaryOperator<String> {

    @Override
    public String apply(String str1, String str2) {
        if (str1.length() >= str2.length()){
            return str1;
        }else{
            return str2;
        }
    }
}
