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

    @Override
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

    @Override
    public int updateMenu(String findName) {
        String changeName = "";
        int changePrice = 0;
        int changeStock = 0;

        System.out.println(findName + "의 이름을 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println(findName + "의 이름을 무엇으로 수정하시겠습니까?");
            changeName = sc.next();
        }
        System.out.println("가격을 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("가격을 얼마로 수정하시겠습니까?");
            changePrice = sc.nextInt();
        }
        System.out.println("재고를 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            changeStock = sc.nextInt();
        }


        System.out.println("판매중인 상품으로 등록하시겠습니까?");
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
            int result = psmt.executeUpdate();
            if (result > 0) {
                System.out.println("메뉴 수정 완료했습니다.");
            } else {
                System.out.println("메뉴 수정 실패했습니다.");
            }
        } catch (SQLException e) {
            System.out.println(
                    e.getMessage()
            );
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMenu(String findName) {
        sql = "DELETE FROM productdto WHERE productName = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, findName);
            int result = psmt.executeUpdate();
            if (result > 0) {
                System.out.println("유저 삭제 성공했습니다.");
            } else {
                System.out.println("유저 삭제 실패했습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    @Override
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

    @Override
    public int addUser(UserDto userDto) {
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

    @Override
    public int updateUser(String findId) {
        String changePwd = "";
        String changeName = "";
        String changeNum = "";

        System.out.println("비밀번호를 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정할 비밀번호 입력");
            changePwd = sc.next();
        }
        System.out.println("이름을 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정할 이름 입력");
            changeName = sc.next();
        }
        System.out.println("전화번호를 수정하시겠습니까?");
        if (sc.next().equalsIgnoreCase("y")) {
            System.out.println("수정 전화번호 입력");
            changeNum = sc.next();
        }

        sql = "UPDATE userdto SET pwd = ?, userName = ?, telNum = ?, updateAt = ? WHERE userId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, changePwd);
            psmt.setString(2, changeName);
            psmt.setString(3, changeNum);
            psmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            psmt.setString(5, findId);

            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("유저 정보 수정을 완료했습니다.");
            } else {
                System.out.println("유저 정보 수정 실패 했습니다.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int deleteUser(String findId) {
        sql = "DELETE FROM userdto WHERE userId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1, findId);
            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("유저 삭제를 완료했습니다.");
            } else {
                System.out.println("유저 삭제 실패 했습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    @Override
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
                if (rs.getTimestamp("updateAt") != null) {
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

    @Override
    public int productSales() {
        sql = "SELECT p.productName AS 제품명, COUNT(p.pId) AS `팔린 개수`, SUM(p.price) AS `총 금액` " +
                "FROM sales s " +
                "JOIN productdto p ON s.pId = p.pId " +
                "GROUP BY p.productName";
        try (PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                String pName = rs.getString("제품명");
                int count = rs.getInt("팔린 개수");
                int sum = rs.getInt("총 금액");
                System.out.println("제품명 : " + pName + ", 팔린 개수 : " + count + ", 총 금액 : " + sum);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int userSales() {
        sql = "SELECT u.userId AS 아이디, u.userName AS 이름, SUM(p.price) AS 구매금액, u.userMoney AS 충전잔액 " +
                "FROM sales s JOIN userdto u on s.uId = u.uId " +
                "JOIN productdto p on p.pId = s.pId " +
                "GROUP BY u.userId, u.userName, u.userMoney";
        try (PreparedStatement psmt = dbConn.prepareStatement(sql);
             ResultSet rs = psmt.executeQuery()) {
            while (rs.next()) {
                String userId = rs.getString("아이디");
                String uName = rs.getString("이름");
                int sum = rs.getInt("구매금액");
                int userMoney = rs.getInt("충전잔액");

                System.out.println("아이디: " + userId + " 이름: " + uName + " 구매금액: " + sum + " 충전잔액: " + userMoney);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }
}
