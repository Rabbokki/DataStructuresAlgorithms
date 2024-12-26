package vendingMachineV3.view;

import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.service.AdminService;

import java.util.Scanner;

public class AdminView {
    Scanner sc = new Scanner(System.in);
    AdminService adminService = new AdminService();
    public void mainAdminView(){
        System.out.println("관리자 메뉴입니다.\n" +
                "메뉴를 선택하세요.");
        int menuNum = 0;
        while (menuNum != 3){
            System.out.println("1: 자판기 관리 2: 회원 관리 3: 판매 관리 4. 종료=>");
            menuNum = sc.nextInt();
            switch (menuNum){
                case 1:
                    productManagerView();
                    break;
                case 2:
                    break;
            }
        }
    }
    public void productManagerView(){
        int menuNum = 0;
        while (menuNum != 4){
            System.out.println("자판기 관리 메뉴 입니다. \n" +
                    "1. 물건추가 2. 물건수정 3. 물건삭제 4. 물건조회 5. 종료=>");
            menuNum = sc.nextInt();
            switch (menuNum){
                case 1:
                    adminService.addMenu();
                    break;
                case 2:
                    adminService.updateMenu();
                    break;
                case 3:
                    adminService.deleteMenu();
                    break;
                case 4:
                    adminService.getAllMenu();
                    break;
                case 5:
                    return;
            }
        }
    }
}
