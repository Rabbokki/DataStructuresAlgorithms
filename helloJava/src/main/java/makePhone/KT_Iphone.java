package makePhone;

public class KT_Iphone extends IPhone {
    String name = "KT에서 개통한 아이폰";

    @Override
    public void name() {
        System.out.println(name);
    }

    @Override
    public void os() {
        super.os();
    }

    @Override
    public void touch() {
        super.touch();
    }

    @Override
    public void kakao() {
        super.kakao();
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
