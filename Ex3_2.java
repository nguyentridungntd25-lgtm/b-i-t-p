package ra.edu;

import java.util.Scanner;

public class Ex3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows, cols;
        System.out.print("Nhập số hàng: ");
        rows = sc.nextInt();
        System.out.print("Nhập số cột: ");
        cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        System.out.println("Nhập các phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("arr[" + i + "][" + j + "] = ");
                arr[i][j] = sc.nextInt();
            }
        }
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumEven += arr[i][j];
                } else {
                    sumOdd += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: " + sumEven);
        System.out.println("Tổng các số lẻ: " + sumOdd);
        sc.close();
    }
}

