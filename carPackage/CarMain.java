package carPackage;

import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Car hyunDai = new Car("현대",2000,"그랜저");
        Car kia = new Car("기아",2000,"k5");
        Car samSung = new Car("삼성",2000,"sm6");

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c = str.charAt(0);

        hyunDai.setNavigation(true);
        hyunDai.setColor("White");

        kia.setNavigation(false);
        kia.setColor("Black");

        samSung.setNavigation(true);
        samSung.setColor("Black");

//        while (true){
//            if(c == 'g') {
//                hyunDai.speedUp();
//            } else if (c == 's') {
//                hyunDai.speedDown();
//            }
//        }


    }

}
