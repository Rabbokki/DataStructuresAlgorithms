package genericTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectTest {
    public static void main(String[] args) {
        Object dog = new Dog();
        Object cat = new Cat();

        List<Object> animalList = new ArrayList<>();
        Map<Integer,Dog> map = new HashMap<>();

        animalList.add(dog);
        animalList.add(cat);

        System.out.println(((Dog)dog).getName());

        Cat mycat = ((Cat)cat);
        System.out.println(mycat.getName());
    }
}
