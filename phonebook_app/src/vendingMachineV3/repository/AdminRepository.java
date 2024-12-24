package vendingMachineV3.repository;

import vendingMachineV3.db.DbConnect;
import vendingMachineV3.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository implements AdminRepositoryInterface{
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
}
