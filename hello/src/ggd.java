public class ggd {
    public static void main(String[] args) {
        System.out.println("===========구구단===========");

        for (int i = 2; i < 10; i++) {
            System.out.println(i + "단");
            System.out.println();
            for (int j = 1; j < 10; j++) {
                System.out.printf(i + " * "+ j + " = " + i * j);
                System.out.println();
            }
            System.out.printf(" ");
        }
    }
}
