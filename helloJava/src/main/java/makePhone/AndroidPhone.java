package makePhone;

public class AndroidPhone extends Phone{
    String name = "나는 안드로이드폰";
    boolean touch = false;
    boolean kakao = false;


    @Override
    public void os() {
        System.out.println("OS는 Android");
    }

    public void name() {
    }

    @Override
    public void touch() {
        if(touch) {
            System.out.println("터치 안됨");
        }else System.out.println("터치 기능 있음");
    }

    @Override
    public void kakao() {
        if(kakao) {
            System.out.println("카톡 안됨");
        }else System.out.println("카톡 가능");
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
