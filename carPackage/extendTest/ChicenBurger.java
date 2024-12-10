package carPackage.extendTest;

public class ChicenBurger extends Hamburger{
    private String name = "치킨버거";

    private String 재료3 = "닭다리 치킨";

    @Override
    public void order() {
        System.out.println("치킨버거 주문 완료");
    }

    public void eating(){
        System.out.println("치킨버거를 먹습니다.");
    }

    public String get재료3(){
        return this.재료3;
    }

    public String getName(){
        return this.name;
    }
}
