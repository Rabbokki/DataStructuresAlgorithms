package db.repository;

import db.DBConn;
import db.dto.TelBookDTO;

import java.sql.*;
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
        //DB에 저장
        try{
            sql="INSERT INTO phone_book(name, age, address, phone, created_at) ";
            sql= sql + "VALUES(?,?,?,?,?)";
            psmt = dbConn.prepareStatement(sql);
            //전달할 인자값을 psmt에 추가
            psmt.setString(1,dto.getName());
            psmt.setInt(2,dto.getAge());
            psmt.setString(3, dto.getAddress());
            psmt.setString(4, dto.getPhone());
            psmt.setTimestamp(5, Timestamp.valueOf(dto.getCreatedAt()));

            return psmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateData(TelBookDTO dto) {
        sql = "UPDATE phone_book set name = ";



        System.out.println("[PhoneBookRepository]-updateData");
        return 0;
    }

    @Override
    public int deleteData(Long id) {
        System.out.println("[PhoneBookRepository]-deleteData");
        sql = "DELETE FROM phone_book WHERE id =?";
        try {
            psmt = dbConn.prepareStatement(sql);
            psmt.setLong(1,id);
            return psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
                dto.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
//                dto.getCreatedAt(rs.getTimestamp("created_at"));
//                dto.getCreatedAt(rs.getTimestamp("created_at"));

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
    public TelBookDTO findById(Long findId) {
        System.out.println("[PhoneBookRepository]-findById");
        List<TelBookDTO> list = new PhoneBookRepository().getAllList();

        for (TelBookDTO dto : list) {
            if(dto.getId() == findId){
                return dto;
            }
        }
        return null;
    }

    @Override
    public List<TelBookDTO> findByName(String name) {
        System.out.println("[PhoneBookRepository]-findByName");
        List<TelBookDTO> list = new PhoneBookRepository().getAllList();
        List<TelBookDTO> result = new ArrayList<>();

        for (TelBookDTO dto : list) {
            if(dto.getName().equals(name)){
                result.add(dto);
            }
        }

        return result.isEmpty() ? null : result;
    }

    @Override
    public List<TelBookDTO> findByPhone(String phone) {
        System.out.println("[PhoneBookRepository]-findByPhone");
        List<TelBookDTO> list = new PhoneBookRepository().getAllList();
        List<TelBookDTO> result = new ArrayList<>();

        for (TelBookDTO dto : list) {
            if(dto.getPhone().equals(phone)){
                result.add(dto);
            }
        }

        return result.isEmpty() ? null : result;
    }
}
