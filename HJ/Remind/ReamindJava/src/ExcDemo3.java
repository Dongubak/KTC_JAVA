class ExcDemo3 {
    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 4, 5};
        int num2[] = {1, 0, 2, 0, 3, 7};


        for(int i = 0; i < Math.max(num1.length, num2.length); i++) {
            try {
                int div = num1[i] / num2[i];
                System.out.println(div);
            } catch(ArithmeticException e) {
                System.out.println(e);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                break;
            }
        }
    }
}