interface MyParamValue {
    double getValue(double v);
}

public class LambdaDemo {
    public static void main(String[] args) {
        MyParamValue myPval = (n) -> 1.0 / n;  // 매개변수로 역수 반환
        System.out.println("Reciprocal of 4 is " + myPval.getValue(4.0));
    }
}
