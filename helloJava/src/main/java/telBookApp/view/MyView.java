package telBookApp.view;

import telBookApp.dto.TelBookDto;
import telBookApp.repository.TelBookRepository;
import telBookApp.service.TelBookService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyView {
    TelBookService telBookService = new TelBookService();
    TelBookRepository telBookRepository = new TelBookRepository();
    Scanner sc = new Scanner(System.in);

    public void telBookView(){
        System.out.println("ⓐ 입력\n" +
                "\uD83D\uDCBE 데이터를 입력하는 화면입니다.\n" +
                "✏ 이름 : ");
        String name = sc.next();

        System.out.println("✏ 나이 : ");
        int age = sc.nextInt();

        System.out.println("✏ 주소 : ");
        String address = sc.next();

        System.out.println("✏ 전화번호 : ");
        String telNum = sc.next();


        TelBookDto telBookDto = new TelBookDto(name,age,address,telNum);
        telBookService.insertUser(telBookDto);
    }

    public void deletUserView(){
        System.out.println("\uD83D\uDDD1 데이터를 삭제하는 화면입니다.\n" +
                "✏ 삭제할 아이디를 입력하세요.");
        int num = sc.nextInt();
        telBookService.deleteUser(num);
    }

    public void allRead(){
        telBookService.getListAll();
    }


    public void searchView() {
        System.out.println("\uD83D\uDC53 데이터를 검색하는 화면입니다.\n" +
                "✏ 검색할 이름을 입력하세요.");
        String name = sc.next();
        telBookService.searchUser(name);
    }

    public void updateView() {
        System.out.println("✔ 데이터를 수정하는 화면입니다.\n" +
                "\n" +
                "\uD83D\uDCCC수정할 아이디를 입력하세요");
        int id = sc.nextInt();

        List<TelBookDto> lists = new ArrayList<>();
        lists = telBookRepository.getListAll();

        for (TelBookDto list : lists) {
            if (list.getId()-1 == id){
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

    public void updateView2(){
        System.out.println("✔ 데이터를 수정하는 화면입니다.\n" +
                "\n" +
                "\uD83D\uDCCC수정할 아이디를 입력하세요");
        int id = sc.nextInt();
        telBookService.updateUser(id);
    }
}
