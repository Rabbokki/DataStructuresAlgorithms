package oopEating;

public class Beaf extends Meat{
    private String name = "소고기";
    private String brand = "한우 소고기";

    @Override
    public void eat() {
        System.out.println(name);
    }
}
