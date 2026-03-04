package ra.edu;

import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        int số1;
        int số2;
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập số thứ nhất:  ");
        số1 = sc.nextInt();
        System.out.print("Nhập số thứ hai:  ");
        số2 = sc.nextInt();

        int sum = số1 + số2;
        int difference = số1 - số2;
        int product = số1 * số2;

        if (số2 != 0) {
            int quotient = số1 / số2;
            int remainder = số1 % số2;

            // In kết quả
            System.out.println("First Number: " + số1);
            System.out.println("Second Number: " + số2);
            System.out.println("Tổng: " + sum);
            System.out.println("Hiệu: " + difference);
            System.out.println("Tích: " + product);
            System.out.println("Thương: " + quotient);
            System.out.println("Phần dư: " + remainder);
        } else {
            System.out.println("Không thể chia cho 0!");
            System.out.println("Tổng: " + sum);
            System.out.println("Hiệu: " + difference);
            System.out.println("Tích: " + product);
        }
    }
}
