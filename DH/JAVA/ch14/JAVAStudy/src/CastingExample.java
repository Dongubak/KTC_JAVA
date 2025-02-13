// Java 예시 - 형변환
class Gen4<T> {
    T value;
    Gen4(T value) {
        this.value = value;
    }
}

public class CastingExample {
    public static void main(String[] args) {
        Gen4<Integer> genInt = new Gen4<>(10);

        // 형변환 가능: Gen<Integer> -> Gen<Integer>
        Gen4<Integer> castedGen = genInt;  // 정상

        // 형변환 불가: Gen<Integer> -> Gen<Long>
        // Gen<Long> castedLong = (Gen<Long>) genInt; // 컴파일 오류
    }
}
