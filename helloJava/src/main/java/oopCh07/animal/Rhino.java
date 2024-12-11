package oopCh07.animal;

import oopCh07.WildAnimal;

public class Rhino extends WildAnimal {
    @Override
    public void attack() {
        System.out.println("홀로 공격");
    }
}
