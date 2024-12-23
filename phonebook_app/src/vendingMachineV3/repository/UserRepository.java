package vendingMachineV3.repository;

import db.DBConn;
import vendingMachineV3.db.DbConnect;
import vendingMachineV3.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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
}
