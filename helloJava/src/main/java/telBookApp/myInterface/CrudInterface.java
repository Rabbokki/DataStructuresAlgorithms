package telBookApp.myInterface;

import telBookApp.dto.TelBookDto;

import java.util.List;

public interface CrudInterface {
    // 입력
    int insert(TelBookDto telBook);
    // 수정
    int update(int id);
    // 삭제
    int delete(int id);
    // 전체검색
    List<TelBookDto> getListAll();
    // 단일자료 검색
    TelBookDto getOne(String name);
}
