package ra.edu;

import java.util.Scanner;

public class Ex2_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Nhập cạnh a: ");
        int a = sc.nextInt();
        System.out.print(" Nhập cạnh b: ");
        int b = sc.nextInt();
        System.out.print(" Nhập cạnh c: ");
        int c = sc.nextInt();

        if ( a + b > c && a + c > b && c + b > a ){
            if (a == b && b == c) {
                System.out.println("Đây là tam giác đều");
            }
            else if (a == b || a == c || b == c) {
                System.out.println("Đây là tam giác cân");
            }
            else if (a*a + b*b == c*c ||
                    a*a + c*c == b*b ||
                    b*b + c*c == a*a) {
                System.out.println("Đây là tam giác vuông");
            }
            else {
                System.out.println("Đây là tam giác thường");
            }

        } else {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        }
    }
}
