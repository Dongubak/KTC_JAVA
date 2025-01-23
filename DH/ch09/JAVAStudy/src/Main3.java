class Gen3<T> {
    T value;

    Gen3(T value) {
        this.value = value;
    }

    void showType() {
        System.out.println("Type of T is " + value.getClass().getName());
    }
}

public class Main3 {
    public static void main(String[] args) {
        Gen3 obj1 = new Gen3<>(10);
        Gen3 obj2 = new Gen3<>("Hello");

        obj1.showType();
        obj2.showType();
    }
}