package carPackage.composition;

//만들어져 있는 엔진을 가져다 사용만 할 예정
public class Car {

    private final Engine engine;

    public Car(Engine engine){
        this.engine = engine;
    }

    public int engineInfo(){
        return engine.getPower();
    }
}
