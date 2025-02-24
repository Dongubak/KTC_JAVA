public class ST13 {
    public static void main(String[] args) {
        int nums[] = { 454, 5456, -54412, -56398, -45844, 88, 51455, 45444,
                7787, 45, 1112, 0};

        int min, max;

        min = max = nums[0];
        for (int x : nums){
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }
        System.out.println("max = " + max + " min = " + min );
    }
}
