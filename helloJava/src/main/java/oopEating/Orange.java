package oopEating;

public class Orange implements Fruit{
    private String name = "오렌지";

    private String taste = "시큼한 맛";

    @Override
    public void eat() {
        System.out.println(name);
    }

    @Override
    public String toString() {
        return "Orange{" +
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
