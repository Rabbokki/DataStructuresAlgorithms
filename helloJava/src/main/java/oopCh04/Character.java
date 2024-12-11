package oopCh04;

public class Character {
    public String getName(){
        return " 나는 부모";
    }

//    public void basicAttack(Character character){
//        System.out.println(name + "이" + character + "를 공격한다");
//    }

    public void basicAttack(Character u1){
        System.out.println("부모가 공격함");
    }
}
