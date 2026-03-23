package ra.edu;

class Book {
    String title;
    String author;
    double price;
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class Ex8_2 {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "Nguyen Van B", 15000);
        System.out.println("Thong tin sach:");
        System.out.println("Title: " + b1.title);
        System.out.println("Author: " + b1.author);
        System.out.println("Price: " + b1.price);
    }
}