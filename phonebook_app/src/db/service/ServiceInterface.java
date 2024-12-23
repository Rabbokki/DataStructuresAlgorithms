package db.service;

import db.dto.SearchResultDTO;
import db.dto.TelBookDTO;

import java.util.List;

public interface ServiceInterface {
    int insertService(TelBookDTO dto);

    int updateService(TelBookDTO dto);

    int deleteService(Long id);

    List<TelBookDTO> getAllListService();

    //ID로 검색
    TelBookDTO findByIdService(Long id);

    // 이름으로 검색
    List<SearchResultDTO> findByNameService(String name);

    // 전화번호로 검색
    List<SearchResultDTO> findByPhoneService(String phone);


}
