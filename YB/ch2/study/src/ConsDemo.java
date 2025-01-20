class MyClass {
    int x;

    // 기본 생성자
    MyClass() {
        x = 0;
    }

    // 매개변수 생성자
    MyClass(int i) {
        x = i;
    }

    // 두 개의 매개변수를 받는 생성자
    MyClass(int i, int j) {
        x = i + j;
    } //자바는 소멸자 없음. 얘도 가비지 컬렉터가 알아서함. ㄷㄷ
}

public class ConsDemo {
    public static void main(String[] args) {
        MyClass t1 = new MyClass();         // 기본 생성자 호출
        MyClass t2 = new MyClass(100);     // 매개변수 생성자 호출
        MyClass t3 = new MyClass(10, 20);  // 오버로딩된 생성자 호출

        System.out.println("t1.x: " + t1.x);
        System.out.println("t2.x: " + t2.x);
        System.out.println("t3.x: " + t3.x);
    }
}
