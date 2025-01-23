class Gen<T> {
    Object value;
    Gen(Object v) { value = v; }
    Object getValue() { return value; }
}

public class Main {
    public static void main(String[] args) {
        Gen iOb = new Gen(10);  // Object 타입
        Gen strOb = new Gen("Hello");  // Object 타입

        // 이제 대입이 가능합니다.
        iOb = strOb;  // Error는 발생하지 않음

    }
}
