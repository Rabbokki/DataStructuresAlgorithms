package oopEating;

public class Mango implements Fruit{
    private String name = "망고";
    private String taste = "달콤한 맛";

    @Override
    public void eat() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Mango{" +
                "name='" + name + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTaste() {
        return taste;
    }

    @Override
    public void setTaste(String taste) {

    }
}
