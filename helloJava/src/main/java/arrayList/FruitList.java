package arrayList;

import oopEating.Apple;
import oopEating.Fruit;
import oopEating.Mango;
import oopEating.Orange;

import java.util.ArrayList;
import java.util.List;

public class FruitList {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();
        Apple apple = new Apple();
        fruits.add(apple);
        fruits.add(new Mango());
        fruits.add(new Orange());

        //사이즈 확인하기
        System.out.println("사이즈 : " + fruits.size());
        //전체 출력해보기
        System.out.println(fruits);
        //index = 1인 object 출력해보기

        System.out.println(fruits.get(1));

        Fruit a = fruits.get(1);
        System.out.println(a.getName() + a.getTaste());

        //이름이 오렌지인것을 찾아서 맛을 출력
        for (int i = 0; i < fruits.size(); i++) {
            if(fruits.get(i).getName().equals("오렌지")){
                System.out.println(fruits.get(i).getTaste());
                break;
            }
        }

        //사과의 시큼한 맛을 사과맛으로 바꾸기
        int num = fruits.indexOf(apple);
        System.out.println(num);
        apple.setTaste("사과의 맛");
        System.out.println(apple.getTaste());

        for (Fruit fruit : fruits) {
            if(fruit.getName().equals("사과")){
                fruit.setTaste("사과의 본연의 맛");
            }
            System.out.println(fruit.toString());
            break;
        }

        //사과 삭제하고 출력해보기
        int q = fruits.indexOf(apple);
        fruits.remove(q);

        System.out.println(fruits);

        for (Fruit f : fruits) {
            if(f.getName().equals("사과")){
                fruits.remove(f);
            }
            break;
        }



        for (Fruit f : fruits) {
            if(f.getName().equals("망고")){
                int update = fruits.indexOf(f);
                fruits.set(update,new Apple());
            }
            break;
        }
        System.out.println(fruits);


    }
}
