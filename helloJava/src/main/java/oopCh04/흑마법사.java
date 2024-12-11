package oopCh04;

public class 흑마법사 extends Character{
    String name = "흑마법사";

    @Override
    public String getName() {
        return name;
    }

    public void attack(Character character){
        System.out.println("흑마법사가 " + character.getName() + "공격");
    }
}
