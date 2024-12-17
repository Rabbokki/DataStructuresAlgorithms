package genericTest;

import java.util.ArrayList;
import java.util.List;

public class ObjectTest {
    public static void main(String[] args) {
        Object dog = new Dog();
        Object cat = new Cat();

        List<Object> animalList = new ArrayList<>();
        animalList.add(dog);
        animalList.add(cat);

        System.out.println(((Dog)dog).getName());

        Cat mycat = ((Cat)cat);
        System.out.println(mycat.getName());
    }
}
