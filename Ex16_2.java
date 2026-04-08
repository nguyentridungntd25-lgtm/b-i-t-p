package session16;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex16_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Event> events = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("\nNhập tên sự kiện (hoặc 'exit' để thoát):");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase("exit")) break;

            if (name.trim().isEmpty()) {
                System.out.println("Can not enter empty string");
                continue;
            }

            LocalDateTime startDate = null;
            LocalDateTime endDate = null;
            while (true) {
                try {
                    System.out.println("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm):");
                    String input = sc.nextLine();
                    startDate = LocalDateTime.parse(input, formatter);
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }

            while (true) {
                try {
                    System.out.println("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm):");
                    String input = sc.nextLine();
                    endDate = LocalDateTime.parse(input, formatter);

                    if (endDate.isBefore(startDate)) {
                        System.out.println("End date phải sau start date!");
                        continue;
                    }
                    break;
                } catch (DateTimeParseException e) {
                    System.out.println("Enter not valid date");
                }
            }
            events.add(new Event(name, startDate, endDate));
        }

        System.out.println("\nDanh sách sự kiện:");
        for (Event e : events) {
            System.out.println(e);
        }
        sc.close();
    }
}