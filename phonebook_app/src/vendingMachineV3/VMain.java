package vendingMachineV3;

import vendingMachineV3.view.UserView;

import java.util.Scanner;

public class VMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserView userView = new UserView();
        boolean b = false;

        while (!b){
            System.out.println("저희 자판기는 회원제로 운영되는 자판기 입니다.\n" +
                    "회원이면 1번 회원이 아니라 가입을 원하시면 2번을 눌러주세요.");
            switch(sc.nextInt()){
                case 1:
                    userView.loginView();
                    break;
                case 2:
                    userView.registerView();
                    break;
            }
        }


    }
}
