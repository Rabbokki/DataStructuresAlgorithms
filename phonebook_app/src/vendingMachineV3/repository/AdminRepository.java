package vendingMachineV3.repository;

import vendingMachineV3.db.DbConnect;
import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.dto.UserDto;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRepository implements AdminRepositoryInterface {
    Scanner sc = new Scanner(System.in);
    Connection dbConn = DbConnect.getConnection();
    PreparedStatement psmt = null;
    String sql;
    int result = 0; //쿼리 실행 결과를 담을 변수(성공 : 양수, 실패 : 0)

    @Override
    public List<UserDto> getAllUserList() {
        List<UserDto> dtoList = new ArrayList<>();
        ResultSet rs = null;

        try {
            sql = "SELECT * FROM userdto ORDER BY uId DESC";
            psmt = dbConn.prepareStatement(sql);
            rs = psmt.executeQuery();

            while (rs.next()) {
                UserDto userDto = new UserDto();
                userDto.setuId(rs.getInt("uId"));
                userDto.setUserId(rs.getString("userId"));
                userDto.setPwd(rs.getString("pwd"));
                userDto.setUserName(rs.getString("userName"));
                userDto.setTelNum(rs.getString("telNum"));
                userDto.setUserMoney(rs.getInt("userMoney"));
                userDto.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
                dtoList.add(userDto);
            }
            rs.close();
            psmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    public int addMenu(ProductDto productDto) {
        System.out.println("메뉴추가 레포");
        sql = "INSERT INTO productdto(productName, price, stock, status) VALUES(?,?,?,?)";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, productDto.getProductName());
            psmt.setInt(2, productDto.getPrice());
            psmt.setInt(3, productDto.getStock());
            psmt.setBoolean(4, productDto.getStatus());

            return psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public int updateMenu(String findName) {
        System.out.println(findName + "의 이름을 무엇으로 변경할거냐");
        String changeName = sc.next();
        System.out.println("가격은 무엇으로 수정할거?");
        int changePrice = sc.nextInt();
        System.out.println("재고는 몇으로 수정할거?");
        int changeStock = sc.nextInt();
        System.out.println("판매중으로 할거냐?");
        String y = sc.next();

        sql = "UPDATE productdto SET productName = ?, price = ?, stock = ?, status = ? ";
        sql = sql + "WHERE productName = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, changeName);
            psmt.setInt(2, changePrice);
            psmt.setInt(3, changeStock);
            if (y.equalsIgnoreCase("y")) {
                psmt.setBoolean(4, true);
            } else {
                psmt.setBoolean(4, false);
            }
            psmt.setString(5, findName);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } catch (SQLException e) {
            System.out.println(
                    e.getMessage()
            );
            e.printStackTrace();
        }
        return 0;
    }

    public int deleteMenu(String findName) {
        sql = "DELETE FROM productdto WHERE productName = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, findName);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public List<ProductDto> getAllMenu() {
        sql = "SELECT * FROM productdto";
        List<ProductDto> productDtoList = new ArrayList<>();

        try (PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                ProductDto productDto = new ProductDto();

                productDto.setpId(rs.getInt("pId"));
                productDto.setProductName(rs.getString("productName"));
                productDto.setPrice(rs.getInt("price"));
                productDto.setStock(rs.getInt("stock"));
                productDto.setStatus(rs.getBoolean("status"));

                productDtoList.add(productDto);
            }
            productDtoList.stream().forEach(x -> System.out.println(x));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return productDtoList;
    }

    public int addUser(UserDto userDto) {
        System.out.println("유저입력 레포지토리");
        try {
            sql = "INSERT INTO userdto(userId, pwd, userName, telNum, createdAt) ";
            sql = sql + "VALUES(?,?,?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            //psmt에 값추가
            psmt.setString(1, userDto.getUserId());
            psmt.setString(2, userDto.getPwd());
            psmt.setString(3, userDto.getUserName());
            psmt.setString(4, userDto.getTelNum());
            psmt.setInt(5, userDto.getUserMoney());
            psmt.setTimestamp(6, Timestamp.valueOf(userDto.getCreatedAt()));

            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int updateUser(String findId) {
        String changePwd = "";
        String changeName = "";
        String changeNum = "";

        System.out.println("비밀번호를 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정할 비밀번호 입력");
            changePwd = sc.next();
        }System.out.println("이름을 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정할 이름 입력");
            changeName = sc.next();
        }System.out.println("전화번호를 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정 전화번호 입력");
            changeNum = sc.next();
        }

        sql = "UPDATE userdto SET pwd = ?, userName = ?, telNum = ?, updateAt = ? WHERE userId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1,changePwd);
            psmt.setString(2,changeName);
            psmt.setString(3,changeNum);
            psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            psmt.setString(5,findId);

            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public int deleteUser(String findId) {
        sql = "DELETE FROM userdto WHERE userId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1,findId);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("삭제 성공");
            } else {
                System.out.println("삭제 실패");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }
    public List<UserDto> getAllUser() {
        sql = "SELECT * FROM userdto";
        List<UserDto> userDtoList = new ArrayList<>();

        try (PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                UserDto userDto = new UserDto();

                userDto.setuId(rs.getInt("uId"));
                userDto.setUserId(rs.getString("userId"));
                userDto.setPwd(rs.getString("pwd"));
                userDto.setUserName(rs.getString("userName"));
                userDto.setTelNum(rs.getString("telNum"));
                userDto.setUserMoney(rs.getInt("userMoney"));
                userDto.setCreatedAt(rs.getTimestamp("createdAt")
                        .toLocalDateTime());
                if(rs.getTimestamp("updateAt") != null){
                    userDto.setUpdateAt(rs.getTimestamp("updateAt")
                            .toLocalDateTime());
                }

                userDtoList.add(userDto);
            }
            userDtoList.stream().forEach(x -> System.out.println(x));


        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return userDtoList;
    }

    public void productSales() {

    }

    public void userSales() {
    }
}
