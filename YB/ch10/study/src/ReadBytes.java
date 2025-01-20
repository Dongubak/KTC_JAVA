import java.io.*;

class ReadBytes {
    public static void main(String[] args) throws IOException {
        byte[] data = new byte[10]; // 10바이트 배열 생성
        System.out.println("Enter some characters:");
        System.in.read(data); // 키보드 입력 읽기
        System.out.print("You entered: ");
        for (byte b : data) {
            System.out.print((char) b); // 바이트를 문자로 변환해 출력
        }
    }
}


//2