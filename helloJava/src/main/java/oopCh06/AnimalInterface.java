package oopCh06;

public interface AnimalInterface {
    String getName();

    void speak(); //동물 울음소리 출력

    boolean 육식인가(); //육식인지 초식인지 확인 하는 메서드 (육식은 = true , 초식은 = false)
    String move();
}
