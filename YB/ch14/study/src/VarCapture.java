// 람다 표현식이 로컬 변수를 캡처하는 예제
interface MyFunc {
    int func(int n);
}

class VarCapture {
    public static void main(String args[]) {
        // 캡처 가능한 로컬 변수 (사실상 final)
        int num = 10;

        MyFunc myLambda = (n) -> {
            // num은 변경되지 않으므로 캡처 가능
            int v = num + n;

            // num을 변경하려 하면 오류 발생
            // num++;  // 컴파일 오류

            return v;
        };

        // 람다 실행: num = 10, n = 8 -> 결과: 18
        System.out.println(myLambda.func(8));

        // num을 변경하려 하면 오류 발생
        // num = 9;  // 컴파일 오류
    }
}
