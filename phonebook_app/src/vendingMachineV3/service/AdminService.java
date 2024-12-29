package vendingMachineV3.service;

import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.dto.UserDto;
import vendingMachineV3.repository.AdminRepository;

import java.time.LocalDateTime;
import java.util.List;
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

    public List<ProductDto> getAllMenu() {
        return adminRepository.getAllMenu();
    }

    public int addUser(){
        UserDto userDto = new UserDto();
        System.out.println("회원 등록 메뉴입니다.\n" +
                "회원에 아이디를 입력해주세요.");
        userDto.setUserId(sc.next());
        System.out.println("비밀번호를 입력해주세요.");
        userDto.setPwd(sc.next());
        System.out.println("이름을 입력해주세요.");
        userDto.setUserName(sc.next());
        System.out.println("전화번호를 입력해주세요.");
        userDto.setTelNum(sc.next());
        userDto.setUserMoney(0);
        userDto.setCreatedAt(LocalDateTime.now());

        if(adminRepository.addUser(userDto) > 0){
            System.out.println("회원 등록 완료");
            return 1;
        }else {
            System.out.println("회원 등록 실패");
            return 0;
        }
    }


    public int updateUser() {
        System.out.println("수정할 회원 아이디를 입력하세요.");
        return adminRepository.updateUser(sc.next());
    }

    public int deleteUser() {
        System.out.println("수정할 회원 아이디를 입력하세요.");
        return adminRepository.deleteUser(sc.next());
    }

    public List<UserDto> getAllUser() {
        return adminRepository.getAllUser();
    }

    public int productSales() {
        return adminRepository.productSales();
    }
//
//    public int userSales() {
//        return adminRepository.userSales();
//    }
}
