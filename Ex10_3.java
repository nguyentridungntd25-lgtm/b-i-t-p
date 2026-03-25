package ra.edu;

class Computer {
    public double calculatePrice(double basePrice) {
        System.out.println("Using base price only");
        return basePrice;
    }

    public double calculatePrice(double basePrice, double tax) {
        System.out.println("Using base price + tax");
        return basePrice + basePrice * tax;
    }

    public double calculatePrice(double basePrice, double tax, double discount) {
        System.out.println("Using base price + tax + discount");
        double priceWithTax = basePrice + basePrice * tax;
        return priceWithTax - priceWithTax * discount;
    }

    public class Ex10_3 {
        public static void main(String[] args) {
            Computer c = new Computer();
            double p1 = c.calculatePrice(1000);
            System.out.println("Price 1: " + p1);
            double p2 = c.calculatePrice(1000, 0.1);
            System.out.println("Price 2: " + p2);
            double p3 = c.calculatePrice(1000, 0.1, 0.2);
            System.out.println("Price 3: " + p3);
        }
    }
}