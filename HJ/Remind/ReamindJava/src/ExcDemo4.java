class ExcDemo4 {
    public static void main(String[] args) {
        int num1[] = {1, 2, 3, 4, 5};
        int num2[] = {0, 1, 0, 1, 0, 0};

        for(int i = 0; i < Math.max(num1.length, num2.length); i++) {
            try {
                int div = num1[i] / num2[i];
                System.out.println(div);
            } catch(ArithmeticException e) {
                System.out.println(e);
            } catch(Throwable e) {
                System.out.println(e);
            }
        }
    }
}

//In this case, catch(Throwable) catches all exceptions except for ArrayIndexOutOfBounds-
//Exception. The issue of catching subclass exceptions becomes more important when you
//create exceptions of your own.