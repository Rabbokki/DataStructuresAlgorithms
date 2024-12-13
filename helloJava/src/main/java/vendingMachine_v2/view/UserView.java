package vendingMachine_v2.view;

import vendingMachine_v2.service.AdminService;
import vendingMachine_v2.vo.Product;

import java.util.List;
import java.util.Scanner;

public class UserView {
    AdminService adminService = new AdminService();
    public static int userMoney = 0;
    Scanner sc = new Scanner(System.in);
    public void insertCoin(){
        System.out.println("돈을 넣어 주세요");
        System.out.println("1: 5,000원, 2: 1,000원, 3: 500원, 4: 100원");
        int[] insertMoney = {5000, 1000, 500, 100};
        int number = sc.nextInt();

        switch (number){
            case 1:
                userMoney = userMoney + insertMoney[number-1];
                break;
            case 2:
                userMoney = userMoney + insertMoney[number-1];
                break;
            case 3:
                userMoney = userMoney + insertMoney[number-1];
                break;

            case 4:
                userMoney = userMoney + insertMoney[number-1];
                break;
            default:
                System.out.println("잘못 입력 했습니다.");
        }
        if (number >= 1 || number <= 4){
        System.out.println("투입 금액 : " + insertMoney[number-1] + " 원");
        }
        System.out.println("사용 가능 금액 : " + userMoney + " 원");
    }

    public void retrunMoney(){
        System.out.println(userMoney + " 원 반환 완료");
        userMoney = 0;
        System.out.println("사용 가능 금액 : " + userMoney + " 원");

    }

    public void selectMenu(){
        List<Product> allList = adminService.getAllList();
        if(userMoney ==0){
            System.out.println("동전을 먼저 투입하세요.");
            return;
        }

        //내용출력
        printHeader();
        if (allList.size() == 0){
            System.out.println("현재 자판기에 제품이 없습니다.");
        }else {
            //내용 출력
            for (Product p : allList) {
                System.out.println(p);
            }
        }


        printLine();
        System.out.println("메뉴 선택 화면");
    }

    public void printHeader(){
        System.out.println("===========메뉴===========");
    }
    public void printLine(){
        System.out.println("=========================");
    }

}
