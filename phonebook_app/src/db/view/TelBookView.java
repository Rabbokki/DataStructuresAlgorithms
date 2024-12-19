package db.view;

import db.dto.TelBookDTO;
import db.service.PhoneBookService;

import java.util.List;

public class TelBookView implements ViewInterface{
    PhoneBookService bookService = new PhoneBookService();

    @Override
    public void insertView() {
        System.out.println("[TelBookView] - insertView");
    }

    @Override
    public void updateView() {
        System.out.println("[TelBookView] - updateView");
    }

    @Override
    public void deleteView() {
        System.out.println("[TelBookView] - deleteView");
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
        System.out.println("[TelBookView] - searchNameView");
    }

    @Override
    public void searchPhoneView() {
        System.out.println("[TelBookView] - searchPhoneView");
    }
}
