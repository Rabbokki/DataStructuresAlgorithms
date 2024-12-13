package telBookApp;

import telBookApp.service.TelBookService;
import telBookApp.view.MyView;

import java.util.Scanner;

public class telBookMain {
    public static void main(String[] args) {
        MyView myView = new MyView();
        TelBookService telBookService = new TelBookService();

        Scanner sc = new Scanner(System.in);
        int menuNum = 0;

        while (6 != menuNum){
            telBookService.getListAll();
            System.out.println(" 1.입력 2.수정 3.삭제 4.전체출력 5.아이디검색 6.종료;");
            menuNum = sc.nextInt();

            switch (menuNum){
                case 1:
                    myView.telBookView(); //완료
                    break;
                case 2:
                    System.out.println("수정");
                    myView.updateView2();
                    break;
                case 3:
                    System.out.println("삭제"); //완료
                    myView.deletUserView();
                    break;
                case 4:
                    System.out.println("전체출력");//완료
                    myView.allRead();
                    break;
                case 5:
                    System.out.println("검색"); //완료
                    myView.searchView();
                    break;
                case 6://종료 끝
                    break;
            }

        }

    }
}
