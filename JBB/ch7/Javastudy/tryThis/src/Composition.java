class Engine {
    void start() {
        System.out.println("Engine starting...");
    }
}

class Car {
    Engine engine = new Engine();

    void startCar() {
        engine.start();
        System.out.println("Car is moving.");
    }
}

public class Composition {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}
