package vendingMachineV3.repository;

import vendingMachineV3.db.DbConnect;
import vendingMachineV3.dto.ProductDto;
import vendingMachineV3.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminRepository implements AdminRepositoryInterface{
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

            while (rs.next()){
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
            psmt.setInt(2,productDto.getPrice());
            psmt.setInt(3,productDto.getStock());
            psmt.setBoolean(4,productDto.getStatus());

            return psmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return 0;
    }

    public int updateMenu(String findName) {
        System.out.println("메뉴 수정 레포");
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
            psmt.setString(1,changeName);
            psmt.setInt(2,changePrice);
            psmt.setInt(3,changeStock);
            if(y.equalsIgnoreCase("y")){
                psmt.setBoolean(4,true);
            }else {
                psmt.setBoolean(4,false);
            }
            psmt.setString(5,findName);
            int rowsAffected = psmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("수정 성공");
            }else {
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
            psmt.setString(1,findName);
            int rowsAffected = psmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("삭제 성공");
            }else {
                System.out.println("삭제 실패");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public int getAllMenu() {
        sql = "SELECT * FROM productdto";
        ResultSet rs = null;
        
        try {
            psmt = dbConn.prepareStatement(sql);
            rs = psmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }
}
