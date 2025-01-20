public class test {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try block.");
            return;  // 메인 함수에서 return
        } finally {
            // 이 블록은 실행되지 않음
            System.out.println("Inside finally block.");
        }
    }
}
