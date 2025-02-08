class Gen2<T, V> {
    T ob1;
    V ob2;
    Gen2(T t, V v) { value = t; }
    T getValue() {
        ob1 = value;
        ob2 = v;
        return ob1; }

    void set(T o) {
        ob1 = o;
    }

    void set(V o) {
        ob2 = o;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Gen2<Integer, String> iOb = new Gen2<>(10, "Hello");  // Gen<Integer> 타입

        // 아래는 컴파일 오류가 발생함
        //iOb = strOb;  // Error: cannot convert from Gen<String> to Gen<Integer>
    }
}
