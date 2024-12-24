package vendingMachineV3.repository;

import vendingMachineV3.dto.UserDto;

import java.util.List;

public interface AdminRepositoryInterface {
    List<UserDto> getAllUserList();
}
