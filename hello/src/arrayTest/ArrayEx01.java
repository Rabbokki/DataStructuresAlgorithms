package arrayTest;

public class ArrayEx01 {
    public static void main(String[] args) {
        int[] nums = {3,4,5};
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums.length);
//        System.out.println(nums[3]);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
