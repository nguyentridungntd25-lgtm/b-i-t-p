package ra.edu;

class Car {
    private int currentSpeed = 0;
    public void accelerate() {
        currentSpeed += 10;
        System.out.println("Car accelerates by default: +10 km/h");
    }
    public void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("Car accelerates by " + speed + " km/h");
    }
    public void accelerate(int speed, int seconds) {
        int increase = speed * seconds;
        currentSpeed += increase;
        System.out.println("Car accelerates " + increase + " km/h (speed x time)");
    }
    public void printStatus() {
        System.out.println("Current speed: " + currentSpeed + " km/h");
    }
}
public class Ex10_4 {
    public static void main(String[] args) {
        Car car = new Car();
        car.accelerate();
        car.printStatus();
        car.accelerate(20);
        car.printStatus();
        car.accelerate(5, 3);
        car.printStatus();
    }
}
