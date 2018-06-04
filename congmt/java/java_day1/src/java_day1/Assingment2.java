package java_day1;

import java.util.Scanner;

public class Assingment2 {
	public static void main(String[] args) {
		int a,b,x,y;
		Scanner sc=new Scanner(System.in);
		System.out.println("- Nhập số a: ");
		a= sc.nextInt();
		System.out.println("- Nhập số b: ");
		b= sc.nextInt();
		x=Math.min(a, b);
		y=Math.max(a, b);
		double x1= Math.pow(a,3);
		double x2=Math.sqrt(a);
		int x3=Math.abs(a);
		double x4=Math.ceil(a);
		double x5=Math.floor(a);
		int x6=Math.round(a);
		double x7=Math.random();
		double x8 = Math.toRadians(a);
	    double x9 = Math.toRadians(b);
		

	     
		
		System.out.println("- Số nhỏ nhất trong 2 số là: " + x);
		System.out.println("- Số lớn nhất trong 2 số là: " + y);
		System.out.println("- Lũy thừa của số a là: " + x1);
		System.out.println("- Căn bậc 2 của a là: " + x2);
		System.out.println("- Giá trị tuyệt đối của a là: " + x3);
		System.out.println("- Số nguyên tuyệt đối trên a là: " + x4);
		System.out.println("- Số nguyên tuyệt đối dưới a là: " + x5);
		System.out.println("- Làm tròn số a là: " + x6);
		System.out.println("- Sinh số ngẫu nhiên từ a đến blà: " + x7);
		System.out.println("- Math.cbrt(" + a + ")=" + Math.cbrt(a));
	    System.out.println("- Math.cbrt(" + b + ")=" + Math.cbrt(b));
	    System.out.println("- Math.abs(" + a + ")=" + Math.abs(a));
	    System.out.println("- Math.abs(" + b + ")=" + Math.abs(b));
	    System.out.println("- Math.log(" + a + ")=" + Math.log(a));
	    System.out.println("- Math.log(" + b + ")=" + Math.log(b));
	    System.out.println("- Math.log10(" + a + ")=" + Math.log10(a));
	    System.out.println("- Math.log1p(" + a + ")=" + Math.log1p(a));
	    System.out.println("- Math.max(" + a + "," + b + ")=" + Math.max(a, b));
	    System.out.println("- Math.hypot(" + a + "," + b + ")=" + Math.hypot(a, b));
	    System.out.println("- Math.cosh(" + a + ")=" + Math.cosh(a));
	    System.out.println("- Math.cosh(" + b + ")=" + Math.cosh(b));
	    System.out.println("- Math.cos(" + x8 + ")=" + Math.cos(x8));
	    System.out.println("- Math.cos(" + x9 + ")=" + Math.cos(x9));
	    System.out.println("- Math.exp(" + a + ")=" + Math.exp(a));
	    System.out.println("- Math.exp(" + b + ")=" + Math.exp(b));
	    System.out.println("- Math.min(" + a + "," + b + ")=" + Math.min(a, b));
	}
}

