package oopEating;

public class Chicken extends Meat{
    private String name = "치킨";

    private String brand = "하림 닭고기";

    @Override
    public void eat() {
        System.out.println(name);
    }
}
