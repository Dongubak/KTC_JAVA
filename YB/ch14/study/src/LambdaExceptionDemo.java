import java.io.*;

// 함수형 인터페이스 정의
interface MyIOAction {
    boolean ioAction(Reader rdr) throws IOException;
}

class LambdaExceptionDemo {
    public static void main(String args[]) throws IOException {
        // IOException을 던질 수 있는 블록 람다
        MyIOAction myIO = (rdr) -> {
            int ch = rdr.read(); // IOException 발생 가능
            // 추가 작업...
            return true;
        };

        // 예제 Reader 사용
        Reader reader = new StringReader("Example");
        try {
            boolean result = myIO.ioAction(reader);
            System.out.println("Operation successful: " + result);
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }
    }
}
