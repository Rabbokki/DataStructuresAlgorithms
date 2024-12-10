package carPackage.extendTest;

public class CheeseHamburger extends Hamburger{
    private String name = "치즈 햄버거";
    private String 재료3 = "치즈 듬뿍";

    @Override
    public void order() {
        System.out.println("치즈버거 주문 완료");
    }

    public String get재료3(){
        return this.재료3;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
