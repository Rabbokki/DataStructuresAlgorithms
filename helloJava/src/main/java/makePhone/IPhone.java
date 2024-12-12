package makePhone;

public class IPhone extends Phone {
    String name = "나는 아이폰";
//    boolean touch = false;
//    boolean kakao = false;

    public void name() {
    }

    @Override
    public void os() {
        System.out.println("OS는 IOS");
    }

    @Override
    public void touch() {
        System.out.println("당근 터치 됨.");
    }

    @Override
    public void kakao() {
        System.out.println("당근 카카오 됨.");
    }

    @Override
    public void call() {
        System.out.println("통화 무조건 됨");
    }

    @Override
    public void message() {
        System.out.println("메시지 보내짐");
    }
}
