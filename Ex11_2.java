package ra.edu;

abstract class Payment {
    protected double amount;
    public Payment(double amount) {
        this.amount = amount;
    }
    public abstract void pay();

    public void printAmount() {
        System.out.println("Số tiền: " + amount);
    }
}
interface Refundable {
    void refund();
}
class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }
    @Override
    public void pay() {
        System.out.println("Thanh toán bằng tiền mặt");
    }
}
class CreditCardPayment extends Payment implements Refundable {

    public CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán bằng thẻ tín dụng");
    }

    @Override
    public void refund() {
        System.out.println("Hoàn tiền qua thẻ tín dụng");
    }
}
class EWalletPayment extends Payment implements Refundable {

    public EWalletPayment(double amount) {
        super(amount);
    }

    @Override
    public void pay() {
        System.out.println("Thanh toán qua ví điện tử");
    }
    @Override
    public void refund() {
        System.out.println("Hoàn tiền qua ví điện tử");
    }
}
public class Ex11_2 {
    public static void main(String[] args) {
        Payment[] payments = new Payment[3];

        payments[0] = new CashPayment(100);
        payments[1] = new CreditCardPayment(200);
        payments[2] = new EWalletPayment(300);

        for (Payment p : payments) {
            p.printAmount();
            p.pay();

            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }
        }
    }
}