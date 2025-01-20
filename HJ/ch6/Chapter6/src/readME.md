## Call By Reference
```java
public class Test {
    int a, b;

    Test(int i, int j) {
        a = i;
        b = j;
    }

    void change(Test ob) {
        ob.a = ob.a + ob.b;
        ob.b = -ob.b;
    }
}
public class CallByReference {
    public static void main(String[] args) {
        Test ob = new Test(15, 20);

        System.out.println(ob.a + " " + ob.b);
        ob.change(ob);
        System.out.println(ob.a + " " + ob.b);
    }
}
```

## static Block
- Static Block은 클래스가 처음 로드될 때 실행되는 코드 블록이다.
- 클래스의 static 메서드나 static 변수가 사용되기 전에 자동으로 실행된다.
- static 변수 초기화나 리소스 설정 등의 작업에서 수행된다.

```java
class StaticBlock {
    // static 변수 선언
    static double rootOf2;
    static double rootOf3;

    // static 블록
    static {
        System.out.println("Inside static block.");
        rootOf2 = Math.sqrt(2.0);  // 2의 제곱근 계산
        rootOf3 = Math.sqrt(3.0);  // 3의 제곱근 계산
    }

    // 생성자
    StaticBlock(String msg) {
        System.out.println(msg);
    }
}
```

위 처럼 참조에 의한 전달인 경우 change 메서드의 전달인자로 얻은 ob는 객체 자기 자신을 가리키며 복사가 아닌 식별자만
같은 자기 자신을 가리킨다.

## static 제어자

1. They can directly call only other static methods.
2. They can directly access only static data.
3. They do not have a this reference.

### this 에 관해
```java
class MyClass {
    int x;

    MyClass setX(int x) {
        this.x = x;
        return this;  // 현재 객체를 반환
    }

    void printX() {
        System.out.println("x = " + this.x);
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.setX(10).printX();  // 메서드 체이닝
    }
}
```

이 처럼 메서드 체이닝이 가능하다.

pp.210