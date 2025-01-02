package javaTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("고용형태 - 정규직<P>, 임시직<T>를 입력하세요.");
        String s = sc.next();
        if(s.equalsIgnoreCase("P")){
            System.out.println("이름을 입력하세요.");
            String name = sc.next();
            System.out.println("기본급을 입력하세요.");
            int salary = sc.nextInt();
            System.out.println("보너스를 입력하세요.");
            int bonus = sc.nextInt();

            Employee permanent = new Permanent(name, salary, bonus);

            System.out.println("================================");
            System.out.println("고용형태 : 정규직");
            System.out.println("이      름 : " + permanent.getName());
            System.out.println("급      여 : " + permanent.getPay(salary,bonus));
        }else if(s.equalsIgnoreCase("T")){
            System.out.println("이름, 작업 시간, 시간당 급여를 입력하세요.");
            System.out.println("이름을 입력하세요.");
            String name = sc.next();
            System.out.println("작업시간을 입력하세요.");
            int time = sc.nextInt();
            System.out.println("시간당급여를 입력하세요.");
            int pay = sc.nextInt();

            Employee temporary = new Temporary(name,time,pay);
            System.out.println("================================");
            System.out.println("고용형태 : 임시직");
            System.out.println("이      름 : " + temporary.getName());
            System.out.println("급      여 : " + temporary.getPay(time,pay));
        }
    }
}
