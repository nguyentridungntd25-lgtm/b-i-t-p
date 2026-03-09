package ra.edu;

import java.util.Scanner;

public class Ex2_3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhập 1 số nguyên N: ");
        int n = sc.nextInt();
        n = Math.abs(n);
        int tong = 0;
        while (n > 0){

            int chuso = n % 10;
            tong += chuso;
            n = n / 10;
        }
        System.out.println("Tổng các chữ số là: " + tong);
    }
}
