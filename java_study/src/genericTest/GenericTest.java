package genericTest;

public class GenericTest {
    public static void main(String[] args) {
//        Basket basket = new Basket();
        Dog dog = new Dog();
//
//        basket.setData(dog);
//        ((Dog)basket.getData()).getName();

        Basket<Dog> dogBasket = new Basket<>();
        dogBasket.add(dog);
        System.out.println(dogBasket.get().getName());
    }
}
