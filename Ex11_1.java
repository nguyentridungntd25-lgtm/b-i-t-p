package ra.edu;

// Abstract class Shape
abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();

    public void displayInfo() {
        System.out.println("Hình: " + name);
    }
}

interface Drawable {
    void draw();
}

class Rectangle extends Shape implements Drawable {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }
    @Override
    public double getArea() {
        return width * height;
    }
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    @Override
    public void draw() {
        System.out.println("Đã vẽ hình chữ nhật");
    }
}
class Circle extends Shape implements Drawable {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public void draw() {
        System.out.println("Đã vẽ hình tròn");
    }
}

public class Ex11_1 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle(5, 3);
        shapes[1] = new Circle(4);

        for (Shape s : shapes) {
            s.displayInfo();
            System.out.println("Diện tích: " + s.getArea());
            System.out.println("Chu vi: " + s.getPerimeter());

            ((Drawable) s).draw();

        }
    }
}