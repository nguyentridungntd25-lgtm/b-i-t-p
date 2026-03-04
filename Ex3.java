package ra.edu;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
                int a,b,c,d;
        System.out.println("Nhập số thứ nhất: ");
        a = sc.nextInt();
        System.out.println("Nhập số thứ hai: ");
        b = sc.nextInt();
        System.out.println("Nhập số thứ ba: ");
        c = sc.nextInt();
        System.out.println("Nhập số thứ tư: ");
        d = sc.nextInt();

        if(b==0 || d==0){
            System.out.print("Mẫu số phải khác 0");
        }
        else{
            int tuso = a*d + b*c;
            int mauso = b*d;

            System.out.println("Tổng 2 phân số là: "+ tuso+"/"+mauso);
        }
    }
}
