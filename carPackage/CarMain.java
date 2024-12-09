package carPackage;

public class CarMain {
    public static void main(String[] args) {
        Car hyunDai = new Car("현대",2000,"그랜저");
        Car kia = new Car("기아",2000,"k5");
        Car samSung = new Car("삼성",2000,"sm6");

        hyunDai.setNavigation(true);
        hyunDai.setColor("White");
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedUp();
        hyunDai.speedDown();
        System.out.println("현재 스피드 " + hyunDai.speed);

        kia.setNavigation(false);
        kia.setColor("Black");

        samSung.setNavigation(true);
        samSung.setColor("Black");

        kia.myCarPrint(kia);

    }

}
