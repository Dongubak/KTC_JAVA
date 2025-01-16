class Overload2 {
    void f(int x) {
        System.out.println("Inside f(int): " + x);
    }

    void f(double x) {
        System.out.println("Inside f(double): " + x);
    }
}

class TypeConv {
    public static void main(String[] args) {
        Overload2 ob = new Overload2();
        int i = 10;
        double d = 10.1;
        byte b = 99;
        short s = 10;
        float f = 11.5F;

        ob.f(i);  // calls f(int)
        ob.f(d);  // calls f(double)
        ob.f(b);  // calls f(int) – byte가 int로 변환
        ob.f(s);  // calls f(int) – short가 int로 변환
        ob.f(f);  // calls f(double) – float가 double로 변환
    }
}