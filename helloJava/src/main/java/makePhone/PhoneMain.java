package makePhone;

public class PhoneMain {
    public static void main(String[] args) {
        // KT 아이폰 구매 후 기능확인
        IPhone ktIphone = new KT_Iphone();
        ktIphone.name();
        ktIphone.call();
        ktIphone.message();
        ktIphone.os();
        ktIphone.touch();
        ktIphone.kakao();

        System.out.println("==============");
        // KT 안드로이드 폰 구매 후 기능확인
        AndroidPhone ktAndroid = new KT_AndroidPhone();
        ktAndroid.name();
        ktAndroid.call();
        ktAndroid.message();
        ktAndroid.os();
        ktAndroid.touch();
        ktAndroid.kakao();


        System.out.println("==============");
        // KT 안드로이드 폴더폰 구매 후 기능확인
        AndroidPhone ktFolder = new KT_FolderPhone();
        ktFolder.name();
        ktFolder.call();
        ktFolder.message();
        ktFolder.os();
        ktFolder.touch();
        ktFolder.kakao();
    }
}
