package ra.edu;

class Student {
    int id;
    String name;
    int age;
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
public class Ex8_1 {
    public static void main(String[] args) {
        Student sv = new Student(101, "Nguyen Van A", 20);
        System.out.println("Thong tin sinh vien:");
        System.out.println("ID: " + sv.id);
        System.out.println("Name: " + sv.name);
        System.out.println("Age: " + sv.age);
    }
}
