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
    public int insertCoin(LoginDto loginDto){
        System.out.println("돈을 넣어주세요.");
        return userRepository.insertCoin(loginDto,sc.nextInt());
    }
    public int returnMoney(LoginDto loginDto){
        return userRepository.returnMoney(loginDto);
    }

    public int selectMenu(LoginDto loginDto) {
        return userRepository.selectMenu(loginDto);
    }
}
