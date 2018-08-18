package java_day11;

import java.util.Scanner;

public class sosanh {
	public static void main(String[]args) {
		int a, b, c, x, y;
		// Nhập giá trị từ bàn phím
		Scanner myInput = new Scanner(System.in);
		System.out.println("- Nhập vào số a : ");
		a= myInput.nextInt();
		System.out.println("- Nhập vào số  b : ");
		b= myInput.nextInt();
		System.out.println("- Nhập vào số  c : ");
		c= myInput.nextInt();
		x= Math.min(a,Math.min(b, c));
		y= Math.max(a,Math.max(b, c));
		
		System.out.println("- Số nhỏ nhất trong 3 số là :" + x);	
		System.out.println("- Số lớn nhất trong 3 số là :" + y);
		
	}
}
