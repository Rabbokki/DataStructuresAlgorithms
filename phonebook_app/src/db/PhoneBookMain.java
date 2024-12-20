package db;

import db.view.TelBookView;

import java.sql.Connection;
import java.util.Scanner;

public class PhoneBookMain {
    public static void main(String[] args) {
        TelBookView view = new TelBookView();
        Scanner sc = new Scanner(System.in);

        int num = 0;
//        Connection dbConn = DBConn.getConnection();
        while (true){
            System.out.println("1. 입력 2. 수정 3. 삭제 4. 전체 출력 5. 이름 검색 6. 전화번호 검색 7. 종료");
            num = sc.nextInt();

            switch (num){
                case 1:
                    view.insertView();
                    break;
                case 2:
                    System.out.println("수정");
                    view.updateView();
                    break;
                case 3:
                    System.out.println("삭제");
                    view.deleteView();
                    break;
                case 4:
                    System.out.println("전체 출력");
                    view.searchAllView();
                    break;
                case 5:
                    System.out.println("이름 검색");
                    view.searchNameView();
                    break;
                case 6:
                    System.out.println("전화번호 검색");
                    view.searchPhoneView();
                    break;
                case 7:
                    DBConn.close();
                    return;

                default:
                    System.out.println("잘못 입력했습니다.");
            }
        }
    }
}
