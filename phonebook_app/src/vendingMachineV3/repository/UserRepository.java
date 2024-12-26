package vendingMachineV3.repository;

import db.DBConn;
import db.dto.TelBookDTO;
import vendingMachineV3.db.DbConnect;
import vendingMachineV3.dto.LoginDto;
import vendingMachineV3.dto.UserDto;

import java.sql.*;

public class UserRepository implements UserRepositoryInterface{
//    Connection dbConn = DBConn.getConnection();
    Connection dbConn = DbConnect.getConnection();
    PreparedStatement psmt = null;
    String sql;
    int result = 0; //쿼리 실행 결과를 담을 변수(성공 : 양수, 실패 : 0)

    public int register(UserDto userDto){
        System.out.println("회원가입 레포지토리");
        try {
            sql="INSERT INTO userdto(userId, pwd, userName, telNum, createdAt) ";
            sql= sql + "VALUES(?,?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            //psmt에 값추가
            psmt.setString(1, userDto.getUserId());
            psmt.setString(2, userDto.getPwd());
            psmt.setString(3, userDto.getUserName());
            psmt.setString(4, userDto.getTelNum());
            psmt.setTimestamp(5,Timestamp.valueOf(userDto.getCreatedAt()));

            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int login(LoginDto loginDto) {
        System.out.println("로그인 레포");

        String userId = loginDto.getUserId();
        String pwd = loginDto.getPwd();

        sql = "SELECT userId, pwd FROM userdto WHERE userId = ?";

        ResultSet rs = null;

        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1,userId);
            rs = psmt.executeQuery();
            if(rs.next()){
                String rsPwd = rs.getString("pwd");
                if(!rsPwd.equals(pwd)){
                    System.out.println("비밀번호 확인해주세요");
                    return 0;
                }
                System.out.println("로그인 성공");
                return 1;
            }else {
                System.out.println("아이디를 확인해주세요");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }finally {
            try{
                if(rs != null) rs.close();
                if(psmt != null) psmt.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
//        try {
//            psmt = dbConn.prepareStatement(sql);
//            rs= psmt.executeQuery();
//
//            if(!(rs.getString("userId").equals(userId))){
//                System.out.println("아이디를 확인하세요.");
//            } else if(!(rs.getString("pwd").equals(pwd))){
//                System.out.println("비밀번호를 확인하세요.");
//                return 0;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
    public int insertCoin(LoginDto loginDto, int cMoney){
        System.out.println("돈충전 레포");
        String loginId = loginDto.getUserId();


        sql = "UPDATE userdto SET userMoney = userMoney + ? WHERE userId = ?";


        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setInt(1,cMoney);
            psmt.setString(2,loginId);

            System.out.println("Executing SQL: " + sql);
            System.out.println("Parameters: userMoney=" + cMoney + ", userId=" + loginId);

            int rowsAffected = psmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("돈 충전 성공: " + rowsAffected + " rows updated.");
            } else {
                System.out.println("충전 실패: 해당 userId가 존재하지 않음.");
            }
            return rowsAffected;
        } catch (SQLException e) {
            // SQL 예외 처리
            System.out.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 기타 예외 처리
            System.out.println("Unexpected Error: " + e.getMessage());
            e.printStackTrace();
        }
        return 0; // 실패 시 반환값
    }
    public int returnMoney(LoginDto loginDto) {
        System.out.println("잔돈반환 레포");
        String loginId = loginDto.getUserId();

        sql = "UPDATE userdto SET userMoney = 0 WHERE userId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setString(1,loginId);
            int rowsAffected = psmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("잔돈 반환 성공 ");
            } else {
                System.out.println("반환 실패: 해당 userId가 존재하지 않음.");
            }
            return rowsAffected;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return 0;
    }

    public int selectMenu(LoginDto loginDto) {
        System.out.println("메뉴선택 레포");
        String loginId = loginDto.getUserId();


        return 0;
    }

    @Override
    public UserDto findById(int uId) {
//        System.out.println("[PhoneBookRepository]-findById");
        UserDto dto = new UserDto();
        ResultSet rs = null;

        sql = "SELECT * FROM userdto WHERE uId = ?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1, uId);
            rs = psmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    dto.setuId(rs.getInt("uId"));
                    dto.setUserId(rs.getString("userId"));
                    dto.setPwd(rs.getString("pwd"));
                    dto.setUserName(rs.getString("userName"));
                    dto.setTelNum(rs.getString("telNum"));
                    dto.setUserMoney(rs.getInt("userMoney"));
                    dto.setCreatedAt(rs.getTimestamp("createdAt")
                            .toLocalDateTime());
                    if (rs.getTimestamp("updateAt") != null) {
                        dto.setUpdateAt(rs.getTimestamp("updateAt")
                                .toLocalDateTime());
                    }
                }
            }
            return dto;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
