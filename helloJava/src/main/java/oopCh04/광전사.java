package oopCh04;

public class 광전사 extends Character {
    private String name = "광전사";

    public String getName() {
        return name;
    }

    public void basicAttack(Character character){
        System.out.println(name + "이(가) " + character.getName() + " 공격하기");
    }
}
