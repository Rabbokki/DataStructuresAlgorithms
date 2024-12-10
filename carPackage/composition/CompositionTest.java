package carPackage.composition;

public class CompositionTest {
    public static void main(String[] args) {
        Engine engine = new Engine();
        Car car = new Car(engine);

        System.out.println(car.engineInfo());
    }
}
