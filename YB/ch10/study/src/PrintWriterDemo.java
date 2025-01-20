// PrintWriter를 사용하여 Console 출력하기
import java.io.*;

public class PrintWriterDemo {
    public static void main(String args[]) {
        // PrintWriter 객체 생성: System.out에 연결하고 자동 플러싱 설정
        PrintWriter pw = new PrintWriter(System.out, true);

        int i = 10;
        double d = 123.65;

        // PrintWriter를 사용한 다양한 출력
        pw.println("Using a PrintWriter.");
        pw.println(i); // 정수 출력
        pw.println(d); // 실수 출력
        pw.println(i + " + " + d + " is " + (i + d)); // 문자열과 계산 결과 출력
    }
}


//7

//System.out 대신 PrintWriter를 사용하는 이유
//국제화 및 유니코드 지원:
//
//PrintWriter는 문자 기반 클래스이므로, 유니코드와 국제화(Internationalization)에 더 적합합니다.
//System.out은 바이트 기반 클래스인 OutputStream을 사용하여 문자 처리에 비효율적일 수 있습니다.
//더 많은 기능 제공:
//
//PrintWriter는 모든 **기본 타입(primitive types)**과 **객체(Object)**를 출력할 수 있는 print()와 println() 메서드를 제공합니다.
//객체를 출력할 때 toString() 메서드를 호출하여 자동으로 문자열로 변환합니다.
//자동 플러싱(Auto-Flushing):
//
//PrintWriter는 flush 옵션을 통해 출력 스트림을 자동으로 비울 수 있습니다.
//이는 데이터가 즉시 출력되도록 보장하며, 이를 통해 예상치 못한 버퍼링 문제를 방지합니다.
