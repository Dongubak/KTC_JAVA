class Test {
    static void genException() {
        int num[] = new int [4];

        int find = num[7];
        System.out.println(find);
    }
}

class ExcDemo2 {
    public static void main(String[] args) {
        try {
            Test.genException();
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }
}