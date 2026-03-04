package ra.edu;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args){
        float radius;

        Scanner sc=new Scanner(System.in);
        System.out.println("Nhập vào bán kính hình tròn: ");
        radius=sc.nextFloat();
        double A = Math.PI*radius*radius;
        System.out.println("Diện tích hình tròn: "+A);
    }
}
