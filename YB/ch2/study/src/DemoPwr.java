class Pwr {
    double b;    // 밑(base)
    int e;       // 지수(exponent)
    double val;  // 결과 값

    // 생성자
    Pwr(double b, int e) {
        this.b = b;
        this.e = e;
        this.val = 1;

        if (e == 0) return;

        for (; e > 0; e--) {
            this.val = this.val * b;
        }
    }

    // 결과 반환
    double get_pwr() {
        return this.val;
    }
}

public class DemoPwr {
    public static void main(String[] args) {
        Pwr x = new Pwr(4.0, 2);
        Pwr y = new Pwr(2.5, 1);
        Pwr z = new Pwr(5.7, 0);

        System.out.println(x.b + " raised to the " + x.e + " power is " + x.get_pwr());
        System.out.println(y.b + " raised to the " + y.e + " power is " + y.get_pwr());
        System.out.println(z.b + " raised to the " + z.e + " power is " + z.get_pwr());
    }
}


// 1. 기본 개념 비교
//특징	Java (this)	C++ (this 포인터)
//역할	현재 객체에 대한 참조를 제공	현재 객체에 대한 포인터를 제공
//형식	참조 (reference)	포인터 (pointer)
//사용 방식	명시적으로 this 키워드를 사용	this는 암시적 포인터로 사용
//포인터 사용 여부	포인터가 아님	this는 객체의 메모리 주소를 담고 있는 포인터
//사용 가능 위치	모든 인스턴스 메서드에서 사용 가능	모든 인스턴스 메서드에서 사용 가능
//다른 생성자 호출	this()를 사용. (첫 번째 줄에서만 호출 가능)	초기화 리스트(:)를 사용. (C++11 이상)