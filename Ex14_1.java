package session14;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ex14_1 {
    public static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;

        while (true) {
            try {
                System.out.print("Nhập một số nguyên ");
                number = scanner.nextInt();

                if (number <= 0) {
                    System.out.println("Số không hợp lệ phải > 0  Vui lòng nhập lại.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Lỗi: phải nhập số nguyên");
                scanner.next(); // xóa dữ liệu sai
            }
        }
        if (isPrime(number)) {
            System.out.println( number + " là số nguyên tố.");
        } else {
            System.out.println( number + " không phải là số nguyên tố.");
        }
        scanner.close();
    }
}