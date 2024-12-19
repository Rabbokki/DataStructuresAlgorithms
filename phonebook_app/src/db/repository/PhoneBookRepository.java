package db.repository;

import db.DBConn;
import db.dto.TelBookDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookRepository implements RepositoryInterface{
    Connection dbConn = DBConn.getConnection();
    PreparedStatement psmt = null;
    String sql;

    int result = 0; //쿼리 실행 결과를 담을 변수(성공 : 양수, 실패 : 0)

    @Override
    public int insertData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-insertData");
        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
        System.out.println("[PhoneBookRepository]-updateData");
        return 0;
    }

    @Override
    public int deleteData(Long id) {
        System.out.println("[PhoneBookRepository]-deleteData");
        return 0;
    }

    @Override
    public List<TelBookDTO> getAllList() {
        System.out.println("[PhoneBookRepository]-getAllList");
        List<TelBookDTO> dtoList = new ArrayList<>();
        //ResultSet에 있는 레코드를 하나씩 읽어서 담을 DTO

        ResultSet rs = null;

        try {
            sql = "SELECT * FROM phone_book ORDER BY id ASC";
            psmt = dbConn.prepareStatement(sql);

            //쿼리 실행할 결과 -> ResultSet()에 리턴
            rs = psmt.executeQuery();
            //ResultSet의 내용을 하나씩 읽어서 dtoList에 담아준다.
            while (rs.next()){
                TelBookDTO dto = new TelBookDTO();
                dto.setId(rs.getLong("id"));
                dto.setName(rs.getString("name"));
                dto.setAge(rs.getInt("age"));
                dto.setPhone(rs.getString("phone"));
                dto.setAddress(rs.getString("address"));
                dto.getCreatedAt(rs.getTimestamp("created_at"));
                dto.getCreatedAt(rs.getTimestamp("created_at"));

                //담은 DTO를 리스트에 담는다.
                dtoList.add(dto);
            }

            //ResultSet 닫기
            rs.close();
            //PrepareStatement 닫기
            psmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @Override
    public TelBookDTO findById(Long id) {
        System.out.println("[PhoneBookRepository]-findById");
        return null;
    }

    @Override
    public List<TelBookDTO> findByName(String name) {
        System.out.println("[PhoneBookRepository]-findByName");
        return null;
    }

    @Override
    public List<TelBookDTO> findByPhone(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhone");
        return null;
    }
}
