package arrayTest.method;

public class MethodTest {
    public static void main(String[] args) {
        printTitle();
        System.out.println("출력하고 다녀옴");

        //두 수를 전달해서 합을 계산하는 메서드
        System.out.println(addNum(5,6));
    }

    static void printTitle(){
        System.out.println("제목 출력");
    }
    static int addNum(int a, int b){
        return a+b;
    }
    static int minusNum(int a, int b){
        return a-b;
    }
}
