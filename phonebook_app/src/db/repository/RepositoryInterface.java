package db.repository;

import db.dto.SearchResultDTO;
import db.dto.TelBookDTO;

import java.util.ArrayList;
import java.util.List;

public interface RepositoryInterface {
    int insertData(TelBookDTO dto);

    int updateData(TelBookDTO dto);

    int deleteData(Long id);

    List<TelBookDTO> getAllList();

    //ID로 검색
    TelBookDTO findById(Long id);

    //이름으로 검색
    // ID로 검색

    // 이름으로 검색
    List<SearchResultDTO> findByName(String name);

    // 전화번호로 검색
    List<SearchResultDTO> findByPhone(String phone);


}
