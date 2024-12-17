package lambda;

public class LambdaExpression {
    public static void main(String[] args) {
        //1. 매개 변수가 하나인 경우 자료형과 괄호 생략 가능
        //2. 매개 변수가 두개 이상인 경우 중괄호를 생략할 수 없다.
        //3. 실행문이 한 문장인 경우 중괄호 생략 가능
        //4.실행문이 한문장이라도 return문이 있으면 중괄호 생략 불가
        //5.실행문이 한 문장의 반환문인 경우 return과 중괄호 모두 생략 가능

        Calc add = (x, y) -> {
            return x+y;
        };

        Calc minus = (x,y) -> x-y;



        System.out.println(add.calculator(3,4));
        System.out.println(minus.calculator(3,4));
    }
}
