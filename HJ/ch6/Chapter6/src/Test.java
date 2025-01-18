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