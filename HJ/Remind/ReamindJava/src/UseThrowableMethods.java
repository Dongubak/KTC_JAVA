class ExcTest {
    static void genException() {
        int nums[] = new int [4];

        System.out.println("Before Exception is generated");

        nums[7] = 10;
        System.out.println("After Exception is generated");
    }
}

class UseThrowableMethods {
    public static void main(String[] args) {

        try {
            ExcTest.genException();
        } catch (ArrayIndexOutOfBoundsException exc) {
            System.out.println(exc);
            exc.printStackTrace();
        }
    }
}