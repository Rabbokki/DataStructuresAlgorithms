package vendingMachineV3.repository;

import vendingMachineV3.dto.UserDto;

public interface UserRepositoryInterface {
    int register(UserDto userDto);
}
