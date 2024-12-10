package carPackage.polymorphism;

public class PolyMain {

    public static void main(String[] args) {
        Back back = new Back();
        System.out.println(back.name);
        back.work();

        Cooker cooker = new Cooker();
        System.out.println(cooker.name);
        cooker.work();

        Cooker backJong = new Back();
        System.out.println(backJong.name);
        backJong.work();
    }

}
