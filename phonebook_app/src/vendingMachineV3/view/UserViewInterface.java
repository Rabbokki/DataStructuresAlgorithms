package vendingMachineV3.view;

import vendingMachineV3.dto.LoginDto;
import vendingMachineV3.dto.UserDto;

public interface UserViewInterface {
    boolean registerView();
    LoginDto loginView();
    void userBuyView(LoginDto loginDto);
}
