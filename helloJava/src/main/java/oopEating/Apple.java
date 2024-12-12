package oopEating;

public class Apple implements Fruit{
    private String name = "사과";
    private String taste = "신맛";

    @Override
    public void eat() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Apple{" +
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

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}
