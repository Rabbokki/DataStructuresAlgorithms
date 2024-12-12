package oopEating;

public class Pork extends Meat{
    private String name = "돼지";
    private String brand = "한돈 돼지고기";

    @Override
    public void eat() {
        System.out.println(name);
    }
}
