package session13;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex13_1 {

    static LinkedList<person> list = new LinkedList<>();
    static Scanner sc = new Scanner(System.in);
    public static String inputNotEmpty(String msg) {
        String input;
        do {
            System.out.print(msg);
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("Vui lòng không để trống");
            }
        } while (input.trim().isEmpty());
        return input;
    }
    public static void addUser() {
        String name = inputNotEmpty("Nhập tên: ");
        String email = inputNotEmpty("Nhập email: ");
        String phone = inputNotEmpty("Nhập SĐT: ");

        list.add(new person(name, email, phone));
        System.out.println(" Thêm thành công");
    }
    public static void deleteUser() {
        String email = inputNotEmpty("Nhập email cần xóa: ");
        Iterator<person> it = list.iterator();
        boolean found = false;
        while (it.hasNext()) {
            person p = it.next();
            if (p.getEmail().equalsIgnoreCase(email)) {
                it.remove();
                found = true;
                System.out.println("Xóa thành công");
                break;
            }
        }
        if (!found) {
            System.out.println(" Không tìm thấy!");
        }
    }

    public static void displayUsers() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("===== DANH SÁCH =====");
        for (person p : list) {
            p.display();
        }
    }
    public static void main(String[] args) {
        int choice;
        do {
            System.out.println(" MENU ");
            System.out.println("1. Thêm");
            System.out.println("2. Xóa");
            System.out.println("3. Hiển thị");
            System.out.println("4. Thoát");
            System.out.print("Chọn ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                case 3:
                    displayUsers();
                    break;
                case 4:
                    System.out.println("Thoát!");
                    break;
                default:
                    System.out.println("Sai lựa chọn!");
            }
        } while (choice != 4);
    }
}