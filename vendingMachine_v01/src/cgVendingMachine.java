
    import java.util.Scanner;

    public class cgVendingMachine {
        static String[] product = new String[5];
        static int[] price = new int[5];
        static int[] stock = new int[5];
        static int productCount = 3; // 현재 등록된 제품 수
        static int profit = 0; // 수익

        public static void initialize() {
            // 초기값 설정
            product[0] = "콜라";
            price[0] = 500;
            stock[0] = 3;

            product[1] = "사이다";
            price[1] = 700;
            stock[1] = 3;

            product[2] = "커피";
            price[2] = 1500;
            stock[2] = 3;

            System.out.println("자판기 초기화 완료!");
        }

        public static void user() {
            Scanner sc = new Scanner(System.in);
            int balance = 0;

            while (true) {
                System.out.println("==================================================");
                System.out.println("자판기입니다.(번호:상품(가격)-재고)");
                for (int i = 0; i < product.length; i++) {
                    System.out.printf("%d:%s(%dW)-%d개\n", i + 1, product[i], price[i], stock[i]);
                }
                System.out.println("==================================================");
                System.out.print("돈을 넣어주세요 (1004 입력 시 관리자 메뉴): ");
                int input = sc.nextInt();

                if (input == 1004) {
                    admin(); // 관리자 메뉴 호출
                    continue;
                }

                balance += input;
                System.out.println("잔액: " + balance + "원");

                while (true) {
                    System.out.println("메뉴를 선택하세요:");
                    for (int i = 0; i < productCount; i++) {
                        System.out.printf("%d:%s(%dW)-%d개\n", i + 1, product[i], price[i], stock[i]);
                    }
                    System.out.print("선택: ");
                    int choice = sc.nextInt() - 1;

                    if (choice < 0 || choice >= productCount) {
                        System.out.println("올바른 번호를 선택해주세요.");
                        continue;
                    }

                    if (stock[choice] <= 0) {
                        System.out.println("죄송합니다. 해당 제품은 품절입니다.");
                        continue;
                    }

                    if (balance >= price[choice]) {
                        stock[choice]--;
                        balance -= price[choice];
                        profit += price[choice];
                        System.out.println(product[choice] + "이(가) 나왔습니다!");
                        System.out.println("잔액: " + balance + "원");
                    } else {
                        System.out.println("잔액이 부족합니다!");
                    }

                    System.out.println("1: 계속구매하기 2: 금액추가하기 3: 잔돈반환하기");
                    int nextAction = sc.nextInt();

                    if (nextAction == 2) {
                        System.out.print("금액을 추가해주세요: ");
                        balance += sc.nextInt();
                        System.out.println("잔액: " + balance + "원");
                    } else if (nextAction == 3) {
                        System.out.println("거스름돈 " + balance + "원이 반환됩니다. 감사합니다!");
                        balance = 0;
                        break;
                    } else if (nextAction == 1) {
                        continue;
                    }
                }
            }
        }

        public static void admin() {
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("==================================================");
                System.out.println("관리자 페이지입니다.");
                System.out.println("1: 메뉴변경 2: 가격변경 3: 재고추가 4: 메뉴추가 5: 수익확인 (종료는 -1)");
                System.out.print("번호를 입력하세요: ");
                int choice = sc.nextInt();

                if (choice == -1) return;

                switch (choice) {
                    case 1: // 메뉴변경
                        System.out.print("변경하실 메뉴의 번호를 입력하세요(1~" + productCount + "): ");
                        int menuIndex = sc.nextInt() - 1;
                        if (menuIndex < 0 || menuIndex >= productCount) {
                            System.out.println("잘못된 입력입니다.");
                            break;
                        }
                        System.out.print(product[menuIndex] + "을(를) 무엇으로 바꾸시겠습니까?: ");
                        product[menuIndex] = sc.next();
                        System.out.print(product[menuIndex] + "의 가격은 얼마입니까?: ");
                        price[menuIndex] = sc.nextInt();
                        System.out.print(product[menuIndex] + "의 재고는 몇 개 입니까?: ");
                        stock[menuIndex] = sc.nextInt();
                        System.out.println("메뉴 변경이 완료되었습니다!");
                        break;

                    case 2: // 가격변경
                        System.out.print("가격을 변경할 메뉴 번호를 입력하세요(1~" + productCount + "): ");
                        menuIndex = sc.nextInt() - 1;
                        if (menuIndex < 0 || menuIndex >= productCount) {
                            System.out.println("잘못된 입력입니다.");
                            break;
                        }
                        System.out.print(product[menuIndex] + "의 가격을 얼마로 바꾸시겠습니까?: ");
                        price[menuIndex] = sc.nextInt();
                        System.out.println("가격 변경이 완료되었습니다!");
                        break;

                    case 3: // 재고추가
                        System.out.print("재고를 추가할 메뉴 번호를 입력하세요(1~" + productCount + "): ");
                        menuIndex = sc.nextInt() - 1;
                        if (menuIndex < 0 || menuIndex >= productCount) {
                            System.out.println("잘못된 입력입니다.");
                            break;
                        }
                        System.out.print(product[menuIndex] + "의 재고를 몇 개 추가하시겠습니까?: ");
                        stock[menuIndex] += sc.nextInt();
                        System.out.println("재고 추가가 완료되었습니다!");
                        break;

                    case 4: // 메뉴추가
                        if (productCount >= 5) {
                            System.out.println("더 이상 메뉴를 추가할 수 없습니다!");
                            break;
                        }
                        System.out.print("추가할 메뉴 이름을 입력하세요: ");
                        product[productCount] = sc.next();
                        System.out.print(product[productCount] + "의 가격을 입력하세요: ");
                        price[productCount] = sc.nextInt();
                        System.out.print(product[productCount] + "의 재고를 입력하세요: ");
                        stock[productCount] = sc.nextInt();
                        productCount++;
                        System.out.println("메뉴 추가가 완료되었습니다!");
                        break;

                    case 5: // 수익확인
                        System.out.println("현재까지의 수익은 " + profit + "원입니다.");
                        break;

                    default:
                        System.out.println("올바른 번호를 입력해주세요.");
                }
            }
        }

        public static void main(String[] args) {
            initialize();
            user();
        }

}
