package session14;

import java.util.*;

public class Ex14_4 {

    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException, Exception {
        if (phone.contains(" ")) {
            throw new Exception("Không được chứa khoảng trắng");
        }
        if (!phone.matches("\\d+")) {
            throw new Exception("Chứa ký tự không hợp lệ");
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Sai độ dài (phải 10 số)");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> validPhones = new ArrayList<>();
        Map<String, String> invalidPhones = new LinkedHashMap<>();
        System.out.print("Nhập danh sách số điện thoại (cách nhau bởi dấu phẩy): ");
        String input = scanner.nextLine();
        String[] phones = input.split(",");
        for (String p : phones) {
            String phone = p.trim();
            try {
                validatePhoneNumber(phone);
                validPhones.add(phone);
            } catch (InvalidPhoneNumberLengthException e) {
                invalidPhones.put(phone, e.getMessage());
            } catch (Exception e) {
                invalidPhones.put(phone, e.getMessage());
            }
        }
        System.out.println("\nSố điện thoại hợp lệ:");
        for (String phone : validPhones) {
            System.out.println("- " + phone);
        }
        System.out.println("\nSố điện thoại không hợp lệ:");
        for (Map.Entry<String, String> entry : invalidPhones.entrySet()) {
            System.out.println("- " + entry.getKey() + " : " + entry.getValue());
        }
        scanner.close();
    }
}