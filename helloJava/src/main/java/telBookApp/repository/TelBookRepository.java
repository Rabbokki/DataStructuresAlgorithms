package telBookApp.repository;

import telBookApp.dto.TelBookDto;
import telBookApp.myInterface.CrudInterface;

import java.util.ArrayList;
import java.util.List;


public class TelBookRepository implements CrudInterface {
    List<TelBookDto> telBookDtoList = new ArrayList<>();
    private static int tId = 1;


    @Override
    public int insert(TelBookDto telBookDto) {
        telBookDto.setId(tId++);
        telBookDtoList.add(telBookDto);

        if(telBookDtoList.size()==0){
            return 0;
        }else {
            System.out.println(telBookDtoList);
        }return 1;
    }

    @Override
    public int update(int id) {

        return 0;
    }

    @Override
    public int delete(int id) {
        telBookDtoList.remove(id-1);
        return 0;
    }

    //전체 출력
    @Override
    public List<TelBookDto> getListAll() {
        return telBookDtoList;
    }

    // 이름 검색
    @Override
    public TelBookDto getOne(String name) {
        List<TelBookDto> lists = getListAll();

        for (TelBookDto list : lists) {
            if(list.getName().equals(name)){
                System.out.println(list.getId() + "\t" +list.getName() + "\t"+"\t" + list.getTelNum());
            }
        }
//        for (TelBookDto telBookDto : telBookDtoList) {
//            if(telBookDto.getName().equals(name)){
//                System.out.println(telBookDto.getId()+ "\t" + telBookDto.getName() + "\t" + telBookDto.getTelNum());
//                return telBookDto;
//            }
//        }
        return null;
    }


}
