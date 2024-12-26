package vendingMachineV3.service;

import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.repository.AdminRepository;

import java.util.Scanner;

public class AdminService {
    Scanner sc = new Scanner(System.in);
    AdminRepository adminRepository = new AdminRepository();
    public int addMenu() {
        ProductDto productDto = new ProductDto();
        System.out.println("자판기에 추가할 물건의 이름을 입력해주세요.");
        productDto.setProductName(sc.next());
        System.out.println("가격을 입력해주세요.");
        productDto.setPrice(sc.nextInt());
        System.out.println("재고를 추가해주세요.");
        productDto.setStock(sc.nextInt());
        System.out.println("판매 가능한 상품으로 등록할거요?");
        if(sc.next().equalsIgnoreCase("y")){
            productDto.setStatus(true);
        }else {
            productDto.setStatus(false);
        }

        int result = adminRepository.addMenu(productDto);

        if(result > 0){
            System.out.println("메뉴추가 성공!");
            return result;
        }else {
            System.out.println("메뉴추가 실패ㅠㅠㅠ");
            return 0;
        }
    }

    public int updateMenu() {
        System.out.println("수정할 물건 이름을 입력하세요.");
        return adminRepository.updateMenu(sc.next());
    }

    public int deleteMenu() {
        System.out.println("삭제할 물건 이름을 입력하세요.");
        return adminRepository.deleteMenu(sc.next());
    }

    public int getAllMenu() {
        return adminRepository.getAllMenu();
    }
}
