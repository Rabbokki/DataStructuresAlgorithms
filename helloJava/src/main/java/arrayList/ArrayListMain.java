package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<Integer> intData = new ArrayList<>();
        List<String> strData = new ArrayList<>();

        //리스트 생성시 초기값 부여하는 방법
        List<Integer> init = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(init);

        for (int i : init) {
            System.out.println(i);
        }

        // CRUD(생성 , 읽기 , 수정 , 삭제)
        strData.add("ㅈㅈㅈ");
        strData.add("ㅈㅇㅇ");
        strData.add("ㄹㅈ");
        strData.add("ㄹㅈ");

        System.out.println(strData);

        //갯수 확인
        System.out.println(strData.size());

        //인덱스로 값 찾기
        System.out.println(strData.get(1));

        //로제의 인덱스 값 찾기
        int index = strData.indexOf("ㄹㅈ");
        System.out.println(strData.get(index));

        //삭제하기
        strData.remove("ㄹㅈ");
        System.out.println(strData);

        //데이터 수정
        //로제 추가

        strData.add("로제");
        System.out.println(strData);

        int idx = strData.indexOf("로제");

        //로제를 제니로 수정
        strData.set(strData.indexOf("로제"),"윈터");

        System.out.println(strData);

    }
}
