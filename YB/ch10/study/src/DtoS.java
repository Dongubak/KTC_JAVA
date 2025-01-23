import java.io.*;

class DtoS {
    public static void main(String args[]) {
        String s;

        // FileReader를 BufferedReader로 감싸서 사용
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            // 파일에서 한 줄씩 읽어서 출력
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException exc) {
            System.out.println("I/O 오류: " + exc);
        }
    }
}
//8 텍스트 파일 읽기
//NIO 는 버퍼,채널 개념을 사용하여  병렬 처리, 비차단 I/O, 및 파일 속성 관리와 같은 고급 기능을 지원,
// 파일리더는 간단한 프로젝트에 적합