package makePhone;

public class KT_FolderPhone extends AndroidPhone{
    String name = "KT 안드로이드 폴더폰";
    boolean touch = false;
    boolean kakao = false;

    @Override
    public void os() {
        super.os();
    }

    @Override
    public void name() {
        System.out.println(name);
    }

    @Override
    public void touch() {
        if(touch==false) {
            System.out.println("터치 안됨");
        }else System.out.println("터치 기능 있음");
    }

    @Override
    public void kakao() {
        if(kakao==false) {
            System.out.println("카톡 안됨");
        }else System.out.println("카톡 가능");
    }

    @Override
    public void call() {
        super.call();
    }

    @Override
    public void message() {
        super.message();
    }
}
