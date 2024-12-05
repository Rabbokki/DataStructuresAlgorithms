package exam;

import java.util.Scanner;

public class solution15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//            System.out.println("======================\n" +
//                    "메뉴를 선택하세요\n" +
//                    "======================\n" +
//                    "1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
//            String num = sc.nextLine();
//
//            switch (num){
//                case "1" :
//                    System.out.println("안녕하세요.");
//                    break;
//                case "2" :
//                    System.out.println("삐끼삐끼 춤입니다.");
//                    break;
//                case "3" :
//                    System.out.println("맛나게 먹었습니다.");
//                    break;
//                default:
//                    System.out.println("프로그램을 종료합니다.");
//                    break;
//            }

//        while (true){
//            System.out.println("======================\n" +
//                    "메뉴를 선택하세요\n" +
//                    "======================\n" +
//                    "1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
//            String num = sc.nextLine();
//            switch (num){
//                case "1" :
//                    System.out.println("안녕하세요.");
//                    break;
//                case "2" :
//                    System.out.println("삐끼삐끼 춤입니다.");
//                    break;
//                case "3" :
//                    System.out.println("맛나게 먹었습니다.");
//                    break;
//                default:
//                    System.out.println("프로그램을 종료합니다.");
//                    break;
//            }
        for (int i=0;;) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("======================\n" +
                    "메뉴를 선택하세요\n" +
                    "======================\n" +
                    "1. 인사하기 2. 춤추기 3. 밥먹기  4. 종료하기");
            int num = sc.nextInt();
            if (num==1){
                System.out.println("안녕하세요.");
            } else if (num==2) {
                System.out.println("삐끼삐끼 춤입니다.");
            }else if (num==3) {
                System.out.println("맛나게 먹었습니다.");
            }else {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }



    }
}
