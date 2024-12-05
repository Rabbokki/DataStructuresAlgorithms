package exam;

import java.util.Scanner;

public class solution16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = "";
        String pw = "";

        //로그인 확인 용 변수
        boolean login = false;

        while(true) {
            if(login == false){
                while (true){
                    System.out.println("아이디 : ");
                    id = sc.next();
                    System.out.println("비밀번호 : ");
                    pw = sc.next();
                    if(!id.equals("admin") && !pw.equals("1111")){
                        System.out.println("아이디 또는 비밀번호 확인");
                        continue;
                    } else if (id.equals("admin") && !pw.equals("1111")) {
                        System.out.println("비밀번호가 일치하지 않습니다.");
                        continue;
                    }else {
                        System.out.println("로그인 성공");
                        login = true;
                        break;
                    }

                }
            }
            System.out.println("======================\n" +
                    "메뉴를 선택하세요\n" +
                    "======================\n" +
                    "1. 인사하기 2. 춤추기 3. 밥먹기  4. 로그아웃 5. 종료하기");

            int num = sc.nextInt();
            switch (num){
                case 1: System.out.println("안녕하세요");
                    break;
                case 2: System.out.println("삐끼삐끼 춤입니다.");break;
                case 3: System.out.println("맛나게 먹었습니다.");break;
                case 4:
                    System.out.println("로그아웃 되었습니다");
                    login = false;
                    break;
                case 5: System.out.println("맛나게 먹었습니다.");break;
            }

        }







    }
}
