package lamdaTest;

public class LamdaTest {


    public static void main(String[] args) {

        int a = 3;
        int b = 5;
        System.out.println(add(a,b));

        LamdaTest l = new LamdaTest(){
            public void run(){
                System.out.println("dasd");
            }
        };




    }

    public static int add(int a, int b){
        return a + b;
    }
}
