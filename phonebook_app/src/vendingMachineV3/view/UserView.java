package vendingMachineV3.view;

import vendingMachineV3.dto.UserDto;
import vendingMachineV3.service.UserService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UserView implements UserViewInterface {
    Scanner sc = new Scanner(System.in);
    UserService userService = new UserService();


    @Override
    public boolean registerView() {
        UserDto userDto = new UserDto();
        boolean b = false;

        while (!b){

            System.out.println("회원가입 페이지 입니다.\n" +
                    "아이디를 입력해주세요.");
            userDto.setUserId(sc.next());
            System.out.println("비밀번호를 입력해주세요.");
            userDto.setPwd(sc.next());
            System.out.println("이름을 입력해주세요.");
            userDto.setUserName(sc.next());
            System.out.println("전화번호를 입력해주세요.");
            userDto.setTelNum(sc.next());
            userDto.setUserMoney(0);
            userDto.setCreatedAt(LocalDateTime.now());

            int result = userService.registerService(userDto);
            if(result > 0){
                System.out.println("회원가입을 축하합니다.");
                b=true;
                return true;
            }else {
                System.out.println("회원가입 실패");
                return false;
            }
            System.out.println(userDto);
        }
    }

    @Override
    public void loginView() {
        System.out.println("로그인 페이지 입니다.");
    }
}
