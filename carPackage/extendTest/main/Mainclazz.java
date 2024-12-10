package carPackage.extendTest.main;

import carPackage.extendTest.CheeseHamburger;
import carPackage.extendTest.ChicenBurger;
import carPackage.extendTest.Hamburger;

public class Mainclazz {
    public static void main(String[] args) {
        Hamburger cheese = new CheeseHamburger();
        System.out.println(cheese.getName());
        System.out.println(cheese.get재료1());
        System.out.println(((CheeseHamburger)cheese).get재료3());
        System.out.println("+++++++++++++++++");

        Hamburger chicken = new ChicenBurger();
        System.out.println(chicken.getName());

    }

}
