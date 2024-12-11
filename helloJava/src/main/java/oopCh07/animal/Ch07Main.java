package oopCh07.animal;

import oopCh07.MildAnimal;
import oopCh07.MildMoveInterface;
import oopCh07.WildAnimal;
import oopCh07.WildMoveInterface;

public class Ch07Main {
    public static void moveWildAnimal(WildMoveInterface wild){
        wild.up();
        wild.left();
    }

    public static void moveMildAnimal(MildMoveInterface mild){
        mild.채집();
        mild.right();
    }

    public static void main(String[] args) {
        MildMoveInterface monkey = new Monkey();
        monkey.채집();
        moveMildAnimal(monkey);

        System.out.println("+++++++++++++++++++");

        WildMoveInterface tiger = new Tiger();
//        tiger.attack();
        moveWildAnimal(tiger);
    }
}
