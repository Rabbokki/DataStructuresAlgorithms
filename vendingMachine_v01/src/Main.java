import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static  String[] product = new String[5]; // 제품명
    static  int[] price = new int[5]; // 가격
    static  int[] stock = new int[5]; // 재고 수량

    public static void main(String[] args) {
        initialize();
        User();
    }

    private static void User() {
        while (true){
            System.out.println("====================================================== \n " +
            "자판기입니다.(번호 : 상품(가격) - 재고\n " +
            "1.콜라(500w)-3개 2.사이다(700w)-3개 3.커피(1500w)-3개 \n"
                    +"====================================================== \n " +
                    "돈을 넣어주세요");
            sc.nextInt();
        }
    }

    private static void initialize() {
        //콜라 정보
        product[0] = "콜라";
        price[0] = 500;
        stock[0] = 3;

        //사이다 정보
        product[1] = "사이다";
        price[1] = 700;
        stock[1] = 3;

        //콜라 정보
        product[2] = "커피";
        price[2] = 1500;
        stock[2] = 3;
    }
}