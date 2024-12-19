package db.view;

public class ExceptionTest {

    public static  void divide(int a, int b)throws Exception{
        if(b==0){
            throw new ArithmeticException("0으로 나누면 안됨");
        }

        int c = a/b;
        System.out.println(c);
    }

    public static void main(String[] args) {

        int a;
        int b;

        a = 10;
        b = 0;

        try {
            divide(a,b);
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
}
