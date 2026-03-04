package ra.edu;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        float height , width;
        float area, perimeter;

        Scanner sc=new Scanner(System.in);
        System.out.print("Nhập chiều rộng: ");
        width = sc.nextFloat();

        System.out.print("Nhập chiều cao: ");
        height = sc.nextFloat();

        area = width * height;
        perimeter = 2 * (width + height);

        System.out.println("Diện tích hình chữ nhật: " + area);
        System.out.println("Chu vi hình chữ nhật: " + perimeter);
    }
}
