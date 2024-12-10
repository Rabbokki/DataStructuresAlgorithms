package carPackage;

public class Car {
    String brand; //현대, 기아, 삼성
    String name; //그랜저 , k5 , sm6
    int power = 2000; //2000
    String color; // 흰색 검정 회색
    boolean navigation;
    int speed = 0;

    public Car(String brand,int power, String name) {
        this.brand = brand;
        this.power = power;
        this.name = name;
    }
//파라미터 안줘도됨
    public String getNavigation(Car c) {
        if(c.navigation == true){
            return "있습니다.";
        }else return "없습니다.";
    }
    public String getNavigation() {
        if(this.navigation == true){
            return "있습니다.";
        }else return "없습니다.";
    }

    public void setNavigation(boolean navigation) {
        this.navigation = navigation;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    void speedUp(){
        this.speed += 5;
        System.out.println("출발합니다." +
                "\n현재 속도는 " + this.speed + "Km 입니다.");
        if (this.speed >= 30){
            this.speed = 30;
            System.out.println("학교앞 과속입니다.\n 현재 30Km를 유지합니다.");
        }

    }
    void speedDown(){
        this.speed -= 5;
        if(this.speed==0){
            this.speed = 0;
            System.out.println("멈췄습니다.");
        }
    }
//파라미터 안줘도됨
    void myCarPrint(Car car){
        System.out.println("나의 애마" + car.name + "는 " + car.brand + " 브랜드 " + car.power + " cc입니다.\n" +
                "색상은 " + car.color + " 이고 , 네비게이션은 " + getNavigation(car));
    }
    void myCarPrint(){
        System.out.println("나의 애마" + this.name + "는 " + this.brand + " 브랜드 " + this.power + " cc입니다.\n" +
                "색상은 " + this.color + " 이고 , 네비게이션은 " + getNavigation());
    }
}
