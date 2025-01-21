class MyClass {
    int x;
    MyClass(int x) {
        this.x = x;
    }
    final public String toString() {
        return "MyClass with x = " + x;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass(10);
        System.out.println(obj.toString());  // MyClass with x = 10
    }
}
