package oopCh04;

public class 궁수 extends Character{
   private String name = "궁수";

    public String getName() {
        return name;
    }

    public void basicAttack(Character character){
        System.out.println(name + "이(가) " + character.getName() + " 공격하기");
    }
}
