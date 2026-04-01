package session13_3;

import java.util.ArrayList;
import java.util.Scanner;

interface Manage<T> {
    void add(T item);
    void update(int index, T item);
    void delete(int index);
    void display();
}

class InvoiceManager implements Manage<Invoice> {
    private ArrayList<Invoice> list = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        list.add(item);
    }
    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < list.size()) {
            list.set(index, item);
        } else {
            System.out.println("Vị trí không hợp lệ!");
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

public class Ex13_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InvoiceManager manager = new InvoiceManager();
        int choice;
        do {
            System.out.println(" MENU QUẢN LÝ HÓA ĐƠN");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Nhập mã hóa đơn ");
                    String code = sc.nextLine();
                    System.out.print("Nhập số tiền ");
                    double amount = Double.parseDouble(sc.nextLine());
                    manager.add(new Invoice(id, code, amount));
                    System.out.println("Hóa đơn đã được thêm thành công");
                    break;
                case 2:
                    System.out.print("Nhập ID cần sửa");
                    int idUpdate = Integer.parseInt(sc.nextLine());

                    int indexUpdate = manager.findById(idUpdate);

                    if (indexUpdate != -1) {
                        System.out.print("Nhập mã mới ");
                        String newCode = sc.nextLine();
                        System.out.print("Nhập số tiền mới ");
                        double newAmount = Double.parseDouble(sc.nextLine());
                        manager.update(indexUpdate, new Invoice(idUpdate, newCode, newAmount));
                        System.out.println("Sửa thành công");
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID cần xóa ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    int indexDelete = manager.findById(idDelete);
                    if (indexDelete != -1) {
                        manager.delete(indexDelete);
                        System.out.println("Hóa đơn đã được xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy");
                    }
                    break;
                case 4:
                    manager.display();
                    break;
                case 5:
                    System.out.println("Thoát");
                    break;
                default:
                    System.out.println("Sai lựa chọn");
            }
        } while (choice != 5);
    }
}