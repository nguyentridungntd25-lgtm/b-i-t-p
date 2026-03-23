package ra.edu;

class Rectangle {
    private double width;
    private double height;
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }
    @Override
    public String toString() {
        return "Rectangle(width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() + ")";
    }
}
public class Ex8_4 {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(3, 4);
        Rectangle r2 = new Rectangle(5, 2);
        Rectangle r3 = new Rectangle(4.5, 3.5);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        Rectangle maxRect = r1;
        boolean duplicate = false;
        if (r2.getArea() > maxRect.getArea()) {
            maxRect = r2;
            duplicate = false;
        } else if (r2.getArea() == maxRect.getArea()) {
            duplicate = true;
        }
        if (r3.getArea() > maxRect.getArea()) {
            maxRect = r3;
            duplicate = false;
        } else if (r3.getArea() == maxRect.getArea()) {
            duplicate = true;
        }
        if (duplicate) {
            System.out.println("Co nhieu hinh co dien tich lon nhat bang nhau");
        } else {
            System.out.println("Hinh co dien tich lon nhat");
            System.out.println(maxRect);
        }
    }
}
