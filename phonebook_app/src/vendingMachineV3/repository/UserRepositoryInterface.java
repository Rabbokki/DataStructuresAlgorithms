package vendingMachineV3.repository;

import db.dto.TelBookDTO;
import vendingMachineV3.dto.LoginDto;
import vendingMachineV3.dto.UserDto;

public interface UserRepositoryInterface {
    int register(UserDto userDto);
    int login(LoginDto loginDto);
    int insertCoin(LoginDto loginDto, int cMoney);
    int returnMoney(LoginDto loginDto);
    int selectMenu(LoginDto loginDto);
}
