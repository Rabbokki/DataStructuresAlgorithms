package arrayTest.method;

public class MiniHouse {
    static int a = 3;
    static int b = 4;
    public static void main(String[] args) {
        JunyongStore js = new JunyongStore();
//        js.printTitle("이거 찍어줘");

        //두 수를 바꾸는 메서드를 static으로 만들어라
//        int a=3;
//        int b=4;

        //바꾸기전
        String data = "a = " + a + ", b =" + b;
        js.printTitle(data);

        //두 수를 바꾸는 메서드를 호출
        swapData();
        data = "a = " + a + ", b =" + b;
        js.printTitle(data);
    }

    private static void swapData() {
        int tmp = a;
        a = b;
        b=tmp;
    }

}
