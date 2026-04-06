package session14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex14_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> validNumbers = new ArrayList<>();
        int invalidCount = 0;
        System.out.println("Nhập các chuỗi (gõ 'exit' để kết thúc):");
        while (true) {
            System.out.print("Nhập ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                validNumbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Không phải số nguyên hợp lệ");
                invalidCount++;
            }
        }
        System.out.println("KẾT QUẢ ");
        System.out.println("Số chuỗi hợp lệ: " + validNumbers.size());
        System.out.println("Số chuỗi không hợp lệ: " + invalidCount);
        System.out.println("Danh sách số nguyên hợp lệ: " + validNumbers);
        scanner.close();
    }
}