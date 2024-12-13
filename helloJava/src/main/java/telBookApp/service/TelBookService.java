package telBookApp.service;

import telBookApp.dto.TelBookDto;
import telBookApp.repository.TelBookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelBookService {
    TelBookRepository telBookRepository = new TelBookRepository();
    Scanner sc = new Scanner(System.in);

    //Create
    public void insertUser(TelBookDto telBookDto){
         telBookRepository.insert(telBookDto);
    }

    //ReadAll
    public List<TelBookDto> getListAll(){
        List<TelBookDto> telBookDtoList = new ArrayList<>();
        telBookDtoList = telBookRepository.getListAll();
        if(telBookDtoList.isEmpty()) {
            System.out.println("====================================\n" +
                    "ID\t이름\t나이\t주소\t전화번호\n" +
                    "데이터가 없습니다.\n" +
                    "====================================");
        }else {
            System.out.println("====================================\n" +
                    "ID\t이름\t나이\t주소\t전화번호\n" +
                    "====================================");
            for (TelBookDto telBookDto : telBookDtoList) {
                System.out.println(telBookDto);
            }
            System.out.println("====================================");
        }

        return telBookDtoList;
    }

    //delete
    public boolean deleteUser(int id){
//        telBookRepository.delete(id);
        if (telBookRepository.delete(id) != 0){
            System.out.println("존재하지 않는 ID입니다.");
            return false;
        }else {
            System.out.println("정상적으로 삭제 되었습니다.");
            return true;
        }

    }

    public void updateUser(int id){
        List<TelBookDto> lists = new ArrayList<>();
        lists = telBookRepository.getListAll();

        for (TelBookDto list : lists) {
            if (list.getId() == id){
                System.out.println("\uD83D\uDCBE 저장된 이름 : " + list.getName());
                System.out.println("\uD83D\uDCCC 수정하시겠습니까?(Y/N)  -  N 입력하면 다음으로 이동");

                if(sc.next().equals("Y")){
                    System.out.println("\uD83C\uDFF7 수정할 이름 : ");
                    list.setName(sc.next());
                }
                System.out.println("\uD83D\uDCBE 저장된 나이 : " + list.getAge());
                System.out.println("\uD83D\uDCCC 수정하시겠습니까?(Y/N)  -  N 입력하면 다음으로 이동");

                if(sc.next().equals("Y")){
                    System.out.println("\uD83C\uDFF7 수정할 나이 : ");
                    list.setAge(sc.nextInt());
                }
                System.out.println("\uD83D\uDCBE 저장된 주소 : " + list.getAddress());
                System.out.println("\uD83D\uDCCC 수정하시겠습니까?(Y/N)  -  N 입력하면 다음으로 이동");

                if(sc.next().equals("Y")){
                    System.out.println("\uD83C\uDFF7 수정할 주소 : ");
                    list.setAddress(sc.next());
                }
                System.out.println("\uD83D\uDCBE 저장된 전화번호 : " + list.getTelNum());
                System.out.println("\uD83D\uDCCC 수정하시겠습니까?(Y/N)  -  N 입력하면 다음으로 이동");

                if(sc.next().equals("Y")){
                    System.out.println("\uD83C\uDFF7 수정할 전화번호 : ");
                    list.setAge(sc.nextInt());
                }
                System.out.println("\uD83D\uDC4D 수정이 완료되었습니다.");

                telBookRepository.getListAll();
            }
        }

    }

    public void searchUser(String name) {
        telBookRepository.getOne(name);
    }
}
