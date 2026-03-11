package ra.edu;

import java.util.Scanner;

public class Ex3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                result[index++] = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                result[index++] = arr[i];
            }
        }
        System.out.println("Mảng sau khi sắp xếp:");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
