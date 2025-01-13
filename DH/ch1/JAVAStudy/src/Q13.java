public class Q13 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 2, 8, 1};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
