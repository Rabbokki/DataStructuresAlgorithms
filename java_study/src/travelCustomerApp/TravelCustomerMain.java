package travelCustomerApp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TravelCustomerMain {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();

        Customer jang = new Customer("장원영" , 20, 100);
        Customer ahn = new Customer("안유진" , 21, 100);
        Customer hong = new Customer("홍길동" , 50, 80);

        customers.add(jang);
        customers.add(ahn);
        customers.add(hong);

        //1. 고객명단 추가된 순서대로 출력
        System.out.println("1.고객명단 추가된 순서대로 출력");
        customers.stream().forEach(x-> System.out.println(x));

        //2.고객명단에 추가된 순서대로 이름만 출력하기
//        for (Customer customer : customers) {
//            System.out.println("이름만 출력 : "+customer.getName());
//        }
        System.out.println("2.고객명단에 추가된 순서대로 이름만 출력하기");
        customers.stream().map(x->x.getName()).forEach(x-> System.out.println(x));

        //3.총 여행비용 출력하기
        System.out.println("3.총 여행비용 출력하기");
        int totalSum = customers.stream().mapToInt(x->x.getPrice()).sum();
        System.out.println("총 여행 경비 : " + totalSum);

        //4.21세 이상 고객명단 이름만 오름차순으로 출력
        System.out.println("4.21세 이상 고객명단 이름만 오름차순으로 출력");
        customers.stream().filter(x -> x.getAge() >=21).map(x->x.getName())
                .sorted().forEach(x-> System.out.println(x));

        //5.21세 이상 고객명단 전체 내림차순으로 출력
        System.out.println("5.21세 이상 고객명단 전체 내림차순으로 출력");
        customers.stream().filter(x->x.getAge()>=21).sorted(Comparator.comparing(Customer::getName)
                .reversed()).forEach(System.out::println);
    }
}
