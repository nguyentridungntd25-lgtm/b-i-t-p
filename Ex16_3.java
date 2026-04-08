package session16;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex16_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Gửi tin nhắn");
            System.out.println("2. Xem lịch sử");
            System.out.println("3. Lọc theo người gửi");
            System.out.println("4. Lọc theo ngày");
            System.out.println("0. Thoát");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Nhập tên người gửi:");
                    String sender = sc.nextLine();

                    System.out.println("Nhập nội dung tin nhắn:");
                    String content = sc.nextLine();

                    messages.add(new Message(sender, content, LocalDateTime.now()));
                    break;
                case 2:
                    System.out.println("=== Lịch sử chat ===");
                    messages.forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Nhập tên người cần lọc:");
                    String nameFilter = sc.nextLine();
                    messages.stream()
                            .filter(m -> m.getSender().equalsIgnoreCase(nameFilter))
                            .forEach(System.out::println);
                    break;
                case 4:
                    try {
                        System.out.println("Nhập ngày (dd/MM/yyyy):");
                        String inputDate = sc.nextLine();

                        LocalDate date = LocalDate.parse(inputDate, dateFormatter);

                        messages.stream()
                                .filter(m -> m.getTimestamp().toLocalDate().equals(date))
                                .forEach(System.out::println);

                    } catch (DateTimeParseException e) {
                        System.out.println("Sai định dạng ngày!");
                    }
                    break;
                case 0:
                    System.out.println("Thoát chương trình...");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
