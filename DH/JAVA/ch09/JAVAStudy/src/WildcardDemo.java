// NumericFns 클래스 정의
class NumericFns<T extends Number> {
    T num;

    // 생성자: 숫자 객체를 받음
    NumericFns(T n) {
        num = n;
    }

    // 절대값 비교 메서드
    boolean absEqual(NumericFns<?> ob) {
        // Math.abs()를 사용하여 절대값 비교
        if (Math.abs(num.intValue()) == Math.abs(ob.num.intValue()))
            return true;
        return false;
    }

    // 기타 메서드들 (예: 분수 부분 반환, 역수 계산 등)
    double reciprocal() {
        return 1 / num.doubleValue();
    }

    double fraction() {
        return num.doubleValue() - num.intValue();
    }
}

// 와일드카드를 사용한 예시 실행
public class WildcardDemo {
    public static void main(String args[]) {
        // 다양한 타입의 NumericFns 객체 생성
        NumericFns<Integer> iOb = new NumericFns<Integer>(6);
        NumericFns<Double> dOb = new NumericFns<Double>(-6.1);
        NumericFns<Long> lOb = new NumericFns<Long>(5L);

        // iOb와 dOb의 절대값 비교
        System.out.println("Testing iOb and dOb.");
        if(iOb.absEqual(dOb))
            System.out.println("Absolute values are equal.");
        else
            System.out.println("Absolute values differ.");

        System.out.println();

        // iOb와 lOb의 절대값 비교
        System.out.println("Testing iOb and lOb.");
        if(iOb.absEqual(lOb))
            System.out.println("Absolute values are equal.");
        else
            System.out.println("Absolute values differ.");
    }
}
