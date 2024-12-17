package streamTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayStreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Tomas");
        list.add("Adward");
        list.add("Jack");

        list.stream().forEach(x -> System.out.print(x + "\t"));
        System.out.println();
        list.stream().sorted().forEach(name -> System.out.println(name));
        //리스트 길이 출력
        list.stream().map(x->x.length())
                .forEach(x -> System.out.println(x));
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");
        //문자열 길이가 5이상인 자료 출력
        list.stream().filter(x->x.length() >= 5).sorted().forEach(x-> System.out.println(x));
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("======================================");

        //정수 자료 처리
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);

        integerList.stream().forEach(x-> System.out.println(x));
        int sumValue=integerList.stream().mapToInt(x->x.intValue()).sum();
        System.out.println("리스트 합은 : " + sumValue);

    }
}
