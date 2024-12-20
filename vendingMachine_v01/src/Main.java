import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] product = new String[5]; // 제품명
    static int[] price = new int[5]; // 가격
    static int[] stock = new int[5]; // 재고 수량

    public static void main(String[] args) {
        initialize();
        User();
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


    private static void User() {
        int myMoney = 0;
        int menu = 0;
        int revenue = 0;


        boolean bool = false;

        while (true) {
            if (bool == false) {
                System.out.print("====================================================== \n " +
                        "자판기입니다.(번호 : 상품(가격) - 재고\n " +
                        "1.콜라(500w)-3개 2.사이다(700w)-3개 3.커피(1500w)-3개 \n"
                        + "====================================================== \n " +
                        "돈을 넣어주세요 :");
                myMoney = sc.nextInt();//돈 넣는거 내돈

                if (myMoney == 1004) {
                    System.out.println("====================================================== \n " +
                            "관리자 페이지 입니다. \n" +
                            "1.메뉴 변경 2.가격변경 3.재고추가 4.메뉴추가 5.수익확인(종료는 -1)\n" +
                            "번호를 입력하세요 : ");
                    //1.메뉴 변경
                    int num = sc.nextInt();
                    if (num == 1) {

                        System.out.println("변경할 메뉴 번호를 입력하세요(1~3) : ");
                        num = sc.nextInt();//변경할 메뉴 번호 입력 1,2,3

                        for (int i = 0; i < product.length; i++) {
                            if (num == i+1) {
                                System.out.println(product[num - 1] + "를(을) 무엇으로 바꾸시겠습니까?");
                                String s = sc.next();
                                if (!(s.equals(product[i]))) {
                                    product[i] = s;
                                    System.out.println(s + "의 가격은 얼마입니까? ");
                                    num = sc.nextInt();
                                    price[i] = num;
                                    System.out.println(num);
                                    System.out.println(s + "의 재고를 몇개 등록 하시겠습니까? ");
                                    num = sc.nextInt();
                                    stock[i] = num;
                                    break;
                                }
                            }
                        }


                    } else if (num == 2) {
                        System.out.println("가격을 변경하실 메뉴의 번호를 입력하세요(1~3): ");
                        int n = sc.nextInt();
                        for (int i = 0; i < product.length; i++) {
                            if ((n - 1) == i) {
                                System.out.println(product[i] + "의 가격을 얼마로 바꾸시겠습니까?");
                                num = sc.nextInt();
                                price[i] = num;
                                System.out.println("가격 변경이 완료 되었습니다!");
                            }
                        }
                    } else if (num == 3) {
                        System.out.println("재고를 추가하실 메뉴의 번호를 입력하세요(1~3): ");
                        int n = sc.nextInt();
                        for (int i = 0; i < stock.length; i++) {
                            if ((n - 1) == i) {
                                System.out.println(product[i] + "를(을) 몇 개 추가 하시겠습니까?");
                                num = sc.nextInt();
                                stock[i] += num;
                                System.out.println("재고 추가가 완료 되었습니다!");
                            }
                        }
                    } else if (num == 4) {
                        System.out.println("추가하실 메뉴의 가격을 입력하세요 : ");
                        int n = sc.nextInt();
                        for (int i = 0; i < product.length; i++) {
                            if (!((price.length - 1) == 0)) {
                                price[price.length - 1] = n;
                                System.out.println("추가하실 메뉴의 이름을 입력하세요 : ");
                                String s = sc.next();
                                product[product.length - 1] = s;
                                System.out.println(s + "의 재고는 몇 개 입니까?");
                                int st = sc.nextInt();
                                stock[stock.length - 1] = st;
                                System.out.println("메뉴 추가가 완료 되었습니다.");

                                System.out.println(Arrays.toString(product));
                                System.out.println(Arrays.toString(price));
                                System.out.println(Arrays.toString(stock));
                            }
                            break;
                        }
                    } else if (num == 5) {
                        System.out.println("현재까지 수익은 : " + revenue + " 입니다.");
                    } else {
                        continue;
                    }

                }
                System.out.println("메뉴 입력 : ");
                menu = sc.nextInt();//메뉴넣는거
//                String menuNum = Integer.toString(menu);

                for (int i = 0; i < product.length; i++) {
                    if (menu == i + 1) {
                        System.out.println(product[menu - 1] + "이(가) 나왔다 !");
                        System.out.println("잔액 : " + (myMoney - price[menu - 1]));
                        revenue += (myMoney - price[menu - 1]);

                        int a = stock[menu - 1] - 1;//재고값
                        System.out.println("남은 재고 : " + a);
                        break;
                    }
                    bool = true;
                }
                System.out.println("1. 계속 구매하기\n" +
                        "2. 금액 추가하기\n" +
                        "3. 잔돈 반환하기 \n " +
                        "번호를 입력하세요.");
                //1. 계속 구매하기
                //잔액부족 구현
                if (sc.nextInt() == 1) {
                    bool = false;
                    if (myMoney < 500) {
                        System.out.println("잔액이 부족합니다. 금액을 추가하세요!");
                        continue;
                    }
                } else if (sc.nextInt() == 2) {
                    System.out.println("추가할 금액 입력 : ");
                    myMoney = sc.nextInt();
                    System.out.println("금액이 추가 되었습니다! 잔액 : " + (myMoney - price[menu - 1] + myMoney));
                } else {
                    System.out.println("거스름 돈 " + (myMoney - price[menu - 1]) + "원이 반환 됩니다.");
                    System.out.println("감사합니다! 다음에 또 이용해주세요!!");
                    bool = false;
                }


            }
        }

    }
}