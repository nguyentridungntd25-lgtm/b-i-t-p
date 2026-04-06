package session14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex14_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1_000_000;
        final double MIN_BALANCE = 50_000;
        while (true) {
            try {
                System.out.print("Nhập số tiền muốn rút ");
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println(" Lỗi: Số tiền phải lớn hơn 0");
                    continue;
                }
                if (amount > balance) {
                    System.out.println(" Lỗi: Số tiền rút vượt quá số dư!");
                    continue;
                }
                if (balance - amount < MIN_BALANCE) {
                    System.out.println("Lỗi: Tài khoản phải duy trì số dư tối thiểu 50.000 đồng!");
                    continue;
                }
                balance -= amount;
                System.out.println(" Rút tiền thành công");
                System.out.println("Số tiền đã rút: " + amount);
                System.out.println("Số dư còn lại: " + balance);
                break;
            } catch (InputMismatchException e) {
                System.out.println(" Lỗi: Vui lòng nhập một số hợp lệ!");
                scanner.next();
            }
        }
        scanner.close();
    }
}