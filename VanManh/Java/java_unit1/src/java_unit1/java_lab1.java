package java_unit1;

import java.util.Scanner;

public class java_lab1 {
	public static void main (String [] agrs) {
		String hoten;
		double lp1, lp2, lp3, diemTB;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập họ tên:");
		hoten= input.nextLine();
		
		System.out.print("Nhập điểm lp1:");
		lp1= input.nextDouble();
		
		System.out.print("nNhập điểm lp2:");
		lp2= input.nextDouble();
		
		System.out.print("Nhập điểm lp3:");
		lp3= input.nextDouble();
		
		diemTB=(lp1+lp2+lp3)/3;
		//In ra giá trị
		System.out.print("<<"+hoten+">>"+"<<"+lp1+","+lp2+","+lp3+">>");
		System.out.printf("%.2f",diemTB);

	}
}
