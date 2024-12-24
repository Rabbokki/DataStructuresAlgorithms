package vendingMachineV3.service;

import vendingMachineV3.dto.LoginDto;
import vendingMachineV3.dto.UserDto;
import vendingMachineV3.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserService {
    UserRepository userRepository = new UserRepository();
    Scanner sc = new Scanner(System.in);
    public static int userMoney = 0;

    public int registerService(UserDto userDto){
        return userRepository.register(userDto);
    }
    public int loginService(LoginDto loginDto){
        return userRepository.login(loginDto);
    }
    public void insertCoin(){
        System.out.println("돈을 넣어주세요.\n" +
                "1 : 5000원 2: 1000원 3: 500원 4: 100원");
        int[] insertMoney = {5000, 1000, 500, 100};
        switch (sc.nextInt()){
            case 1:
                userMoney +=insertMoney[sc.nextInt()-1];
                break;
            case 2:
                userMoney += insertMoney[sc.nextInt()-1];
                break;
            case 3:
                userMoney += insertMoney[sc.nextInt()-1];
                break;
            case 4:
                userMoney += insertMoney[sc.nextInt()-1];
                break;
            default:
                System.out.println("다시 입력ㄱㄱ");
        }
        System.out.println("투입 금액 : " + insertMoney[sc.nextInt()-1]);
        System.out.println("사용 가능 금액 : " + userMoney + "원");
    }
    public void returnMoney(){
        System.out.println(userMoney + "원 반환 완료");
        userMoney = 0;
        System.out.println("사용 가능 금액 : " + userMoney + "원");
    }

    public void selectMenu() {

    }
}
