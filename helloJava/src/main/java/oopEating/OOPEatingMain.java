package oopEating;

public class OOPEatingMain {
    public static void main(String[] args) {
        Fruit apple = new Apple();
        Fruit mango = new Mango();
        Vegetarian woman1 = new Vegetarian();
        Vegetarian woman2 = new Vegetarian();
        woman1.vegetableEat(apple);
        woman2.vegetableEat(mango);
        System.out.println("=================");
        Meat pork = new Pork();
        MeatEater man1 = new MeatEater(pork);
        man1.meatEat();
    }
}
