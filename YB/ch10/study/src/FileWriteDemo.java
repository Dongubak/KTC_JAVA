import java.io.*;

public class FileWriteDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fout = new FileOutputStream("output.txt");

        String content = "Java I/O Example";
        byte[] contentBytes = content.getBytes(); // 문자열을 바이트 배열로 변환
        fout.write(contentBytes); // 바이트 배열 쓰기

        fout.close(); // 스트림 닫기
        System.out.println("파일 쓰기 완료!");
    }
}
//5