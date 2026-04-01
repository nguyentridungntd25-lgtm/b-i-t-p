package session13_2;

import java.util.ArrayList;
import java.util.Scanner;

interface Manage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

class AttendanceManager implements Manage<Student> {
    private ArrayList<Student> list = new ArrayList<>();
    @Override
    public void add(Student item) {
        list.add(item);
    }
    @Override
    public void update(int index, Student item) {
        if (index >= 0 && index < list.size()) {
            list.set(index, item);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }
    @Override
    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
        } else {
            System.out.println("Vị trí không hợp lệ");
        }
    }
    @Override
    public void display() {
        if (list.isEmpty()) {
            System.out.println("Danh sách trống");
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).display();
        }
    }
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
public class Ex13_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        int choice;
        do {
            System.out.println(" MENU QUẢN LÝ ĐIỂM DANH ");
            System.out.println("1. Thêm");
            System.out.println("2. Sửa");
            System.out.println("3. Xóa");
            System.out.println("4. Hiển thị");
            System.out.println("5. Thoát");
            System.out.print("Chọn ");

            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    manager.add(new Student(id, name));
                    System.out.println("Thêm thành công");
                    break;
                case 2:
                    System.out.print("Nhập ID cần sửa: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    int indexUpdate = manager.findById(idUpdate);
                    if (indexUpdate != -1) {
                        System.out.print("Nhập tên mới: ");
                        String newName = sc.nextLine();

                        manager.update(indexUpdate, new Student(idUpdate, newName));
                        System.out.println(" Sửa thành công");
                    } else {
                        System.out.println(" Không tìm thấy");
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID cần xóa ");
                    int idDelete = Integer.parseInt(sc.nextLine());

                    int indexDelete = manager.findById(idDelete);

                    if (indexDelete != -1) {
                        manager.delete(indexDelete);
                        System.out.println(" Xóa thành công");
                    } else {
                        System.out.println(" Không tìm thấy");
                    }
                    break;
                case 4:
                    manager.display();
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Sai lựa chọn!");
            }
        } while (choice != 5);
    }
}
