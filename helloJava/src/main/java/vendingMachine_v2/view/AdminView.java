package vendingMachine_v2.view;

import vendingMachine_v2.service.AdminService;
import vendingMachine_v2.vo.Product;

import java.util.List;
import java.util.Scanner;

public class AdminView {

    AdminService adminService = new AdminService();
    Scanner sc = new Scanner(System.in);

    public void insertMenu(){
//        Product product = new Product();
        String item;
        int price;
        int stock;

        System.out.println("자판기 메뉴 등록");
        System.out.println("제품 이름을 입력하세요.");
        item = sc.next();
        System.out.println("제품의 가격? (숫자만 입력)");
        price = sc.nextInt();
        System.out.println("재고 등록(채울 개수)");
        stock = sc.nextInt();

//        product.setItem(item);
//        product.setPrice(price);
//        product.setStock(stock);
        Product product = new Product(item,price,stock);
        adminService.insertItem(product);
    }

    public void deleteMenu(){
        //삭제하기전 목록 확인
        viewAllList();
        System.out.println("삭제할 제품명 입력");
        String itemName = sc.next();
        boolean result = adminService.deleteItem(itemName);
        //삭제 성공 혹은 실패처리
        if(result){
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패");
        }
        viewAllList();
    }

    public void updateMenu(){
        System.out.println("관리자 메뉴 수정 화면");
        viewAllList();

        System.out.println("수정 할 제품명 입력 :");
        String productName = sc.next();

        System.out.println("새로 등록 할 메뉴 이름 입력 :");
        String newItem = sc.next();

        System.out.println("메뉴 가격? (숫자만 입력)");
        int newPrice = sc.nextInt();

        System.out.println("재고 가격? (숫자만 입력)");
        int newStock = sc.nextInt();

        adminService.updateMenu(productName,newItem,newPrice,newStock);
    }

    public void updateStock(){
        viewAllList();
        System.out.println("재고를 수정 할 제품명 입력");
        String itemName = sc.next();

        System.out.println("수정 재고 수량");
        int updateStock = sc.nextInt();

        boolean result = adminService.updateStock(itemName,updateStock);
        if (result){
            System.out.println("재고가 수정 되었습니다.");
            viewAllList();
        }else {
            System.out.println("재고 수정 실패");
            viewAllList();
        }


    }

    public void viewAllList(){
        printHeader();
        //출력
        //1.service에 전체 리스트 요청
        List<Product> productList = adminService.getAllList();

        //2.상품리스트가 비어있을 경우
        if(productList.size()==0){
            System.out.println("현재 자판기에 상품이 없습니다.");
        }else {
            //3.받은 리스트 출력

            for (Product product : productList) {
                System.out.println(product);
            }
        }
        printLine();
    }
    public void printHeader(){
        System.out.println("===========메뉴===========");
    }
    public void printLine(){
        System.out.println("=========================");
    }

}
