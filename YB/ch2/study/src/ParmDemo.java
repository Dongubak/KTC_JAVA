// 단일 파라미터를 사용하는 메서드
class ChkNum {
    // x가 짝수인지 확인하는 메서드
    boolean isEven(int x) {
        return (x % 2) == 0; // x가 2로 나누어 떨어지면 true 반환
    }
}

class ParmDemo {
    public static void main(String args[]) {
        ChkNum e = new ChkNum();

        // 다양한 아규먼트로 메서드 호출
        if (e.isEven(10)) System.out.println("10 is even.");
        if (e.isEven(9)) System.out.println("9 is even.");
        if (e.isEven(8)) System.out.println("8 is even.");
    }
}
//자바는 값전달만함. c++은 값, 참조, 포인터 다 가능