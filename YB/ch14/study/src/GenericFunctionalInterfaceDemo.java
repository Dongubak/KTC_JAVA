// 제네릭 함수형 인터페이스 정의
interface SomeTest<T> {
    boolean test(T n, T m); // 두 개의 같은 타입 매개변수를 받아 boolean 반환
}

class GenericFunctionalInterfaceDemo {
    public static void main(String args[]) {
        // 1. 정수에 대한 람다식: 한 정수가 다른 정수의 약수인지 확인
        SomeTest<Integer> isFactor = (n, d) -> (n % d) == 0;
        if (isFactor.test(10, 2))
            System.out.println("2 is a factor of 10");
        System.out.println();

        // 2. 실수에 대한 람다식: 한 실수가 다른 실수의 약수인지 확인
        SomeTest<Double> isFactorD = (n, d) -> (n % d) == 0;
        if (isFactorD.test(212.0, 4.0))
            System.out.println("4.0 is a factor of 212.0");
        System.out.println();

        // 3. 문자열에 대한 람다식: 문자열 b가 문자열 a에 포함되는지 확인
        SomeTest<String> isIn = (a, b) -> a.indexOf(b) != -1;
        String str = "Generic Functional Interface";
        System.out.println("Testing string: " + str);
        if (isIn.test(str, "face"))
            System.out.println("'face' is found.");
        else
            System.out.println("'face' not found.");
    }
}
