class TwoDShape {
    private double width;
    private double height;

    TwoDShape() {
        width = height = 0.0;
    }
    TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }
    TwoDShape(double size) {
        width = height = size;
    }
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
}
public class ST02 extends TwoDShape {
    ST02(double diameter) {
        super(diameter);
    }
    double area() {
        double diameter = getWidth();
        double radius = diameter / 2;
        double area = radius * radius * Math.PI;
        return (area);
    }

    public static void main(String[] args) {
        ST02 c = new ST02(3.0);
        System.out.println(c.area());
    }
}