package java_d1;

import java.util.Scanner;

public class sosanh {
	public static void main(String[] args) {
		int a,b,c,x,y;
		//nhập giá trị từ bàn phím
		Scanner myInput=new Scanner(System.in);
		System.out.print("Nhập vào số a= ");
		a = myInput.nextInt();
		
		System.out.print("Nhập vào số b= ");
		b = myInput.nextInt();
		System.out.print("Nhập vào số c= ");
		c= myInput.nextInt();
		
		x= Math.min(a, Math.min(c, b));
		y= Math.max(a, Math.max(c,b));
		System.out.println("Số nhỏ nhất là: "+x);
		System.out.println("Số lớn nhất là: "+y);
		
		
		
		
		
		
	}

}
