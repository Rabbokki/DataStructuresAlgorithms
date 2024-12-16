package lamdaTest;

public class Runnable {
    // "Hello"를 출력하는 프로그램
    Runnable task = new Runnable() {

        public void run() {
            System.out.println("Hello");
        }
    };
    Runnable task2 = () -> System.out.println("Hello");


}
