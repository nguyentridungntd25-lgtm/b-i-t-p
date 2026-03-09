package ra.edu;

import java.util.Scanner;

public class Ex2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số tháng (1-12): ");
        int thang = sc.nextInt();
        switch (thang){
            case 1:
                System.out.print("Tháng 1 31 ngày");
                break;
            case 2:
                System.out.print("Tháng 2 28 or 29 ngày");
                break;
            case 3:
                System.out.print("Tháng 3 31 ngày");
                break;
            case 4:
                System.out.print("Tháng 4 30 ngày");
                break;
            case 5:
                System.out.print("Tháng 5 31 ngày");
                break;
            case 6:
                System.out.print("Tháng 6 30 ngày");
                break;
            case 7:
                System.out.print("Tháng 7 31 ngày");
                break;
            case 8:
                System.out.print("Tháng 8 31 ngày");
                break;
            case 9:
                System.out.print("Tháng 9 30 ngày");
                break;
            case 10:
                System.out.print("Tháng 10 31 ngày");
                break;
            case 11:
                System.out.print("Tháng 11 30 ngày");
                break;
            case 12:
                System.out.print("Tháng 12 31 ngày");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
        }

    }
}
