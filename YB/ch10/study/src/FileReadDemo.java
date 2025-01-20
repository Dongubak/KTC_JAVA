import java.io.*;

public class FileReadDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fin = null;

        try {
            fin = new FileInputStream("example.txt"); // 파일 열기
            int i;
            while ((i = fin.read()) != -1) { // EOF(-1)까지 읽기
                System.out.print((char) i); // 읽은 바이트를 문자로 출력
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } finally {
            if (fin != null) fin.close(); // 스트림 닫기
        }
    }
}
//4