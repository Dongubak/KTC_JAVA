class test2_1 {
    public static void main(String[] args) {
        try {
            divide(10, 0);  // 예외를 던지는 함수 호출
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
    }

    public static void divide(int a, int b) throws ArithmeticException{
        System.out.println(a / b);
    }
}