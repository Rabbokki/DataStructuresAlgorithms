package oopCh04;

import OverloadingTest.OverloadingTest;

public class 전사 extends Character{
    private String name = "전사";

    public String getName() {
        return name;
    }
    public void basicAttack(Character character){
        System.out.println(name + "이(가) " + character.getName() + " 공격하기");
    }
}
