package javad1;

import java.util.Scanner;

public class lap1_bai_2 {
    public static void main(String[]args) {
    	System.out.println("bài 2");
    	//khai báo biến
    	double a, b, chuvi, dientich, canhnho;
    	//nhập giá trị từ bàn phím
    	Scanner myInput = new Scanner(System.in);
    	System.out.print("nhâp cạnh a :");
    	a = myInput.nextDouble();
    	System.out.print("nhập cạnh b : ");
    	b = myInput.nextDouble();
    	//so sánh
    	canhnho = Math.min(a,b);
    	System.out.println("chu vi hình chữ nhật : "+(a+b)/2);
    	System.out.println("Diện tích hình chữ nhật : "+(a*b));
    	System.out.println("Cạnh nhỏ nhất là : "+canhnho);
    }
}
