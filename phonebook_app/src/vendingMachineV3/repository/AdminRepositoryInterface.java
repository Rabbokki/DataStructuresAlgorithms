package vendingMachineV3.repository;

import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.dto.UserDto;

import java.util.List;

public interface AdminRepositoryInterface {
    List<UserDto> getAllUserList();
    int addMenu(ProductDto productDto);
    int updateMenu(String findName);
    int deleteMenu(String findName);
    List<ProductDto> getAllMenu();
    int addUser(UserDto userDto);
    int updateUser(String findId);
    int deleteUser(String findId);
    List<UserDto> getAllUser();
    int productSales();
    int userSales();
}
