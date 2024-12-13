package vendingMachine_v2;

import vendingMachine_v2.view.AdminView;
import vendingMachine_v2.view.UserView;

import java.util.Scanner;

public class MachineMain {

    //사용자가 입력한 돈 관리용
    public static int userMoney = 0;

    public static void main(String[] args) {
        UserView userView = new UserView();
        AdminView adminView = new AdminView();

        Scanner sc = new Scanner(System.in);
        int menuNumber = 0;

        while (5 != menuNumber){
            System.out.println("1. 동전 투입 2. 잔돈 반환 3. 메뉴 선택 4. 관리자 메뉴 5. 종료 =>");
            menuNumber = sc.nextInt();

            switch (menuNumber){
                case 1:
                    userView.insertCoin(); //완료
                    break;
                case 2:
                    userView.retrunMoney(); //완료
                    break;
                case 3:
                    userView.selectMenu();
                    break;
                case 4:
                    System.out.println("4. 관리자 메뉴");
                    int adminMenuNumber = 0;

                    while (adminMenuNumber!=6) {
                        System.out.println("1.메뉴 등록 2.메뉴 삭제 3.메뉴 수정 " +
                                "4. 재고 등록 5. 전체목록보기 6. 이전=>");
                        adminMenuNumber = sc.nextInt();

                        switch (adminMenuNumber) {
                            case 1:
                                System.out.println("1.메뉴 등록"); // 완료
                                adminView.insertMenu();
                                break;
                            case 2:
                                System.out.println("2.메뉴 삭제"); //완료
                                adminView.deleteMenu();
                                break;
                            case 3:
                                System.out.println("3.메뉴 수정");
                                adminView.updateMenu();
                                break;
                            case 4:
                                System.out.println("4.재고 등록");
                                adminView.updateStock();
                                break;
                            case 5://완료
                                System.out.println("5.전체 목록 보기");
                                adminView.viewAllList();
                                break;
                            case 6://완료
                                break;
                            default:
                                System.out.println("잘못 입력 하셨습니다.");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("5. 종료"); //완료
                    return;
                default:
                    System.out.println("잘못 입력 하셨습니다.");
                    break;
            }
        }
    }
}
