package myClass;

import org.w3c.dom.ls.LSOutput;

public class ChickenMain {
    public static void main(String[] args) {
        Chicken gyoChon = new Chicken();

        Chicken bbq = new Chicken();

        Chicken jadam = new Chicken();
        jadam.setModel("권은비");
        jadam.getModel();


        gyoChon.order("교촌", "간장치킨", 21000);
        bbq.order("비비큐", "황금올리브", 23000);
        jadam.order("자담", "간장순살치킨", 19000);


    }

}
