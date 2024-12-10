package carPackage.extendTest;

public class ExtendsMain {
    public static void main(String[] args) {
        CheeseHamburger cheeseHamburger = new CheeseHamburger();

        System.out.println(cheeseHamburger.getName());
        System.out.println(cheeseHamburger.get재료1());
        System.out.println(cheeseHamburger.get재료2());
        System.out.println(cheeseHamburger.get재료3());

        System.out.println("=================================");
        System.out.println("=================================");
        System.out.println("=================================");
        ChicenBurger chicenBurger = new ChicenBurger();
        System.out.println(chicenBurger.getName());
        System.out.println(chicenBurger.get재료2());
        System.out.println(chicenBurger.get재료3());
    }
}
