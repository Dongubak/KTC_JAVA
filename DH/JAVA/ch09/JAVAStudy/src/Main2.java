class Gen2<T extends Number> {
    T ob;
    Gen() {
        ob = new T(); // Illegal!!!
    }
}
public class Main2 {
    public static void main(String[] args) {
        Gen2<Integer> iOb = new Gen2<>();  // Gen<Integer> 타입

        // 아래는 컴파일 오류가 발생함
        //iOb = strOb;  // Error: cannot convert from Gen<String> to Gen<Integer>
    }
}
