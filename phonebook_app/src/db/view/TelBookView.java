package db.view;

import db.dto.SearchResultDTO;
import db.dto.TelBookDTO;
import db.service.PhoneBookService;
import exception.InputValidation;
import exception.MyException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class TelBookView implements ViewInterface{
    Scanner sc = new Scanner(System.in);
    PhoneBookService bookService = new PhoneBookService();
    //입력 확인용 인스턴스
    InputValidation validation = new InputValidation();

    @Override
    public void insertView() {

        boolean check = true;
        //빈 연락처 클래스 --> 채워서 서비스로 전달
        TelBookDTO dto = new TelBookDTO();
        //이름 입력
        while (check) {
            try {
                System.out.println("이름  : ");
                String name = sc.next();
                check = validation.nameCheck(name);
                dto.setName(name);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

        //나이 확인
        check = true;
        while (check) {
            try {
                System.out.println("나이  : ");
                int age = sc.nextInt();
                check = validation.ageCheck(age);
                dto.setAge(age);
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        //주소 입력 받기
        System.out.println("주소  : ");
        String address = sc.next();
        dto.setAddress(address);

        //전번 확인
        check = true;
        while (check) {
            try {
                System.out.println("전번 : ");
                String phone = sc.next();
                check = validation.phoneCheck(phone);
                dto.setPhone(phone);

            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }
        dto.setCreatedAt(LocalDateTime.now());
        int result = bookService.insertService(dto);
        if(result > 0){
            System.out.println("자료 저장 완료");
        }else {
            System.out.println("자료 저장 실패 !");
        }
        System.out.println(dto);
    }

    @Override
    public void updateView() {
        System.out.println("[TelBookView] - updateView");
        System.out.println("수정할 아이디 입력");
        Long updateId = sc.nextLong();

        List<TelBookDTO> dtoList = bookService.getAllListService();

        for (TelBookDTO telBookDTO : dtoList) {
            if(updateId == telBookDTO.getId()){
                System.out.println(telBookDTO.getName() + "에 이름을 바꾸세겠습니까?");
                if (sc.next().equalsIgnoreCase("Y")){
                    System.out.println("수정할 이름 : ");
                    telBookDTO.setName(sc.next());
                }
                System.out.println("나이를 바꾸시겠습니까?");
                if (sc.next().equalsIgnoreCase("Y")){
                    System.out.println("수정할 나이 : ");
                    telBookDTO.setAge(sc.nextInt());
                }
                System.out.println("주소를 바꾸시겠습니까?");
                if (sc.next().equalsIgnoreCase("Y")){
                    System.out.println("수정할 주소 : ");
                    telBookDTO.setAddress(sc.next());
                }
                System.out.println("전화번호를 바꾸시겠습니까?");
                if (sc.next().equalsIgnoreCase("Y")){
                    System.out.println("수정할 전화번호 : ");
                    telBookDTO.setAge(sc.nextInt());
                }
                telBookDTO.setUpdateAt(LocalDateTime.now());
            }
            bookService.updateService(telBookDTO);
        }

    }

    @Override
    public void deleteView() {
        System.out.println("[TelBookView] - deleteView");
        System.out.println("삭제할 전화번호 ID 입력 : ");

        Long deleteId = sc.nextLong();
        if(bookService.deleteService(deleteId)>0){
            System.out.println("ID : " + deleteId + "의 데이터가 삭제 되었습니다.");
        }else {
            System.out.println("삭제 실패 !");
        }
    }

    @Override
    public void searchAllView() {
        System.out.println("[TelBookView] - searchAllView");
        List<TelBookDTO> dtoList = bookService.getAllListService();
        //출력해보기
        linePrint();
        printTitle();
        linePrint();

        for (TelBookDTO dto : dtoList) {
            System.out.println(dto);
        }
        linePrint();
    }

    public void linePrint() {
        System.out.println("==========================================================================");
    }
    public void printTitle(){
        System.out.println("ID \t 이름 \t 나이 \t 주소 \t 전화번호 \t 입력 \t 수정");
    }

    @Override
    public void searchNameView() {
//        System.out.println("[TelBookView]-searchNameView");
        System.out.println("이름으로 검색하는 화면입니다.");
        System.out.println("검색할 이름의 일부나 전체를 입력하세요");
        String keyword = sc.next();
        List<SearchResultDTO> result = bookService.findByNameService(keyword);
        linePrint();
        printSearchTitle();
        linePrint();
        // 내용 출력
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            result.forEach(x -> System.out.println(x));
        }
        linePrint();
    }

    @Override
    public void searchPhoneView() {
//        System.out.println("[TelBookView]-searchPhoneView");
        System.out.println("전화번호로 검색하는 화면입니다.");
        System.out.println("검색할 전화번호의 일부나 전체를 입력하세요");
        String keyword = sc.next();
        List<SearchResultDTO> result = bookService
                .findByPhoneService(keyword);
        linePrint();
        printSearchTitle();
        linePrint();
        if (result.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
        } else {
            result.forEach(x -> System.out.println(x));
        }
        linePrint();
    }

    @Override
    public void searchIdView() {
        System.out.println("[TelBookView] - searchIdView");
        System.out.println("아이디 검색 : ");

        Long i = sc.nextLong();

        if(!(bookService.findByIdService(i) == null)){
            System.out.println(bookService.findByIdService(i));
        }else {
            System.out.println("Id가 없습니다.");
        }
    }
    public void printSearchTitle() {
        System.out.println("이름 \t  나이 \t 주소 \t \t 전화번호");
    }
}
