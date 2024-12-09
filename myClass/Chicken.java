package myClass;

public class Chicken {
    public String name;
    public String menuName;
    public int price;
    private String model;


    public Chicken(int price, String menuName, String name) {
        this.price = price;
        this.menuName = menuName;
        this.name = name;
    }

    public void modelPrint(){
        System.out.println(this.name + " 의 ahepfdms " + this.model + "입니다.");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Chicken() {

    }

    public void order(String name,String menuName, int price, String model){
        System.out.println(name + menuName + "을 " + price + "에 주문했습니다.");
    }
    public void order(String name,String menuName, int price){
        System.out.println(name + menuName + "을 " + price + "에 주문했습니다.");
    }
}
