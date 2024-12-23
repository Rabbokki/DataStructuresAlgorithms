package vendingMachineV3.service;

import vendingMachineV3.dto.UserDto;
import vendingMachineV3.repository.UserRepository;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public int registerService(UserDto userDto){
        return userRepository.register(userDto);
    }
}
