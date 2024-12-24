package vendingMachineV3.repository;

import db.DBConn;
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
            sql="INSERT INTO userdto(userId, pwd, userName, telNum, userMoney, createdAt) ";
            sql= sql + "VALUES(?,?,?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            //psmt에 값추가
            psmt.setString(1, userDto.getUserId());
            psmt.setString(2, userDto.getPwd());
            psmt.setString(3, userDto.getUserName());
            psmt.setString(4, userDto.getTelNum());
            psmt.setInt(5,userDto.getUserMoney());
            psmt.setTimestamp(6,Timestamp.valueOf(userDto.getCreatedAt()));

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
}
