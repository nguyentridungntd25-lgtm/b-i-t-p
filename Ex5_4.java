import java.util.Random;
import java.util.Scanner;

public class Ex5_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        System.out.print("Nhập độ dài chuỗi n: ");
        int n = sc.nextInt();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int index = rd.nextInt(characters.length());
            result.append(characters.charAt(index));
        }
        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());
    }
}
