import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ListEx {
    static List<String> product = new LinkedList<>();
    static List<Integer> price = new LinkedList<>();
    static List<Integer> stock = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        initialize();
        user();
        
    }

    private static void user() {
        boolean bool = false;
        int myMoney = 0;


        while (true){
            if(bool == false){
                System.out.println("================================================== \n" +
                        "자판기입니다.(번호:상품(가격)-재고)\n" +
                        "1:콜라(500W)-3개 2:사이다(700W)-3개 3:커피(1500W)-3개\n" +
                        " ================================================== \n" +
                        "돈을 넣어주세요:");
                myMoney = sc.nextInt();
                System.out.println("메뉴 입력 : ");
                int num = sc.nextInt();
                for (int i = 0; i < product.size(); i++) {
                    if(num==1-i){
                        product.get(i+1);
                        System.out.println(product.get(i+1) + "가 나왔다! ");
                        System.out.println("잔액 : " + (myMoney - price.get(i+1)));
                    }
                }
            }
        }
    }

    private static void initialize() {
        product.add("콜라");
        price.add(500);
        stock.add(3);

        product.add("사이다");
        price.add(700);
        stock.add(3);


        product.add("커피");
        price.add(1500);
        stock.add(3);
    }
}
