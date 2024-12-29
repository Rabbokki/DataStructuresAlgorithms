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
                    userManagerView();
                    break;
                case 3:
                    salesManagerView();
                case 4:
                    return;
            }
        }
    }

    private void salesManagerView() {
        int menuNum = 0;
        while (menuNum>=1 || menuNum < 3){
            System.out.println("판매 관리 메뉴 입니다. \n" +
                    "1. 제품별 판매현황 2. 회원별 판매현황 3. 종료=>");
            menuNum = sc.nextInt();
            switch (menuNum){
                case 1:
                    adminService.productSales(); // 제품별 판매현황
                    break;
                case 2:
//                    adminService.userSales(); //회원별 판매현황
                    break;
                case 3:
                    return; //종료 완료
            }
        }
    }

    public void productManagerView(){
        int menuNum = 0;
        while (menuNum>=1 || menuNum < 5){
            System.out.println("자판기 관리 메뉴 입니다. \n" +
                    "1. 물건추가 2. 물건수정 3. 물건삭제 4. 물건조회 5. 종료=>");
            menuNum = sc.nextInt();
            switch (menuNum){
                case 1:
                    adminService.addMenu(); // 물건 추가 완료
                    break;
                case 2:
                    adminService.updateMenu(); //물건 수정 완료
                    break;
                case 3:
                    adminService.deleteMenu(); //물건 삭제 완료
                    break;
                case 4:
                    adminService.getAllMenu(); //물건 조회 완료
                    break;
                case 5:
                    return; //종료 완료
            }
        }
    }
    public void userManagerView(){
        int menuNum = 0;
        while (menuNum>=1 || menuNum < 5){
            System.out.println("회원 관리 메뉴 입니다. \n" +
                    "1. 회원 등록 2. 회원 수정 3. 회원 삭제 4. 회원 조회 5. 종료=>");
            menuNum = sc.nextInt();
            switch (menuNum){
                case 1:
                    adminService.addUser(); // 회원 등록 완료
                    break;
                case 2:
                    adminService.updateUser(); //회원 수정 완료
                    break;
                case 3:
                    adminService.deleteUser(); //회원 삭제 완료
                    break;
                case 4:
                    adminService.getAllUser(); //회원 조회 완료
                    break;
                case 5:
                    return; //종료 완료
            }
        }
    }


}
