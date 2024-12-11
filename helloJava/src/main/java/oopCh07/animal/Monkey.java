package oopCh07.animal;

import oopCh07.MildAnimal;

public class Monkey extends MildAnimal {
    @Override
    public void hide() {
        System.out.println("나무로 숨기");
    }

    @Override
    public void 채집() {
        System.out.println("바나나 모으기");
    }
}
