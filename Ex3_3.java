package ra.edu;

import java.util.Scanner;

public class Ex3_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Nhập số cần tìm: ");
        int x = sc.nextInt();

        int linearIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                linearIndex = i;
                break;
            }
        }
        int left = 0, right = n - 1;
        int binaryIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == x) {
                binaryIndex = mid;
                break;
            } else if (arr[mid] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (linearIndex != -1) {
            System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí " + linearIndex);
        } else {
            System.out.println("Tìm kiếm tuyến tính: Không tìm thấy");
        }

        if (binaryIndex != -1) {
            System.out.println("Tìm kiếm nhị phân: Tìm thấy tại vị trí " + binaryIndex);
        } else {
            System.out.println("Tìm kiếm nhị phân: Không tìm thấy");
        }

    }
}
