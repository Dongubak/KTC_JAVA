class ExcDemo {
    public static void main(String[] args) {
        int nums[] = new int [4];

        try {
            System.out.println(nums[7]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}