package java_d1;

import java.util.Scanner;

public class ass1bai2 {
	public static void main(String[] args) {
		double a,b;
		Scanner sc=new Scanner(System.in);
		System.out.print("Nhập a= ");
		a=sc.nextDouble();
		System.out.print("Nhập b= ");
		b=sc.nextDouble();
		// Lấy số nhỏ nhất của 2 số
		double x1=Math.min(a, b);
		// lấy số lớn nhất của 2 số
		double x2=Math.max(a, b);
		// tính a^n
		double x3=Math.pow(a,2);
		// tính căn bậc 2 của 1 số
		double x4=Math.sqrt(a);
		// lấy giá trị tuyệt đối của 1 số
		double x5=Math.abs(a);
		// lấy số nguyên trên của 1 số
		double x6=Math.ceil(a);
		// lấy số nguyên dưới của 1 số
		double x7=Math.floor(a);
		// làm tròn số 
		double x8=Math.round(a);
		// lấy số ngẫu nhiên từ 0-1
		double x9=Math.random();
		// Trả về gốc khối lập phương của một giá trị
		double x10=Math.cbrt(a);
		// Trả về sqrt ( a^2  + b^2 ) mà không có tràn hoặc tràn trung gian
		double x11=Math.hypot(a, b);
		// Trả về giá trị gần nhất về giá trị cho đối số và bằng một số nguyên toán học
		double x12=Math.rint(a);
		// Trả về sin lượng giác của một góc.
		double x13=Math.sin(a);
		// Trả về tang lượng giác của một góc
		double x14=Math.tan(a);
		// Chuyển đổi một góc được đo bằng radian thành một góc tương đương được đo bằng độ.
		double x15=Math.toDegrees(a);
		// Chuyển đổi một góc được đo bằng độ thành một góc tương đương xấp xỉ tính theo radian
		double x16=Math.toRadians(a);
		// trả về số dấu phẩy động bên cạnh đối số đầu tiên theo hướng của đối số thứ hai.
		double x17=Math.nextUp(a);
		// Trả về cosin lượng giác của một góc.
		double x18=Math.cos(a);
		// Trả về cosin hyperbol của một giá trị
		double x19=Math.cosh(a);
		// Trả về sin hyperbol của một giá trị.
		double x20=Math.sinh(a);
		
		System.out.println("Số nhỏ nhất là: "+x1);
		System.out.println("Số lớn nhất là: "+x2);
		System.out.println("Số bình phương của a là: "+x3);
		System.out.println("Căn bậc hai của a là: "+x4);
		System.out.println("Giá trị tuyệt đối của a là: "+x5);
		System.out.println("Số nguyên trên của a là: "+x6);
		System.out.println("Số nguyên dưới của a là: "+x7);
		System.out.println("Làm tròn số của a là: "+x8);
		System.out.println("Số ngẫu nhiên từ 0-1 là: "+x9);
		System.out.println("Số góc khối lập phương có cạnh là a là: "+x10);
		System.out.println("Căn bậc 2 của tổng 2 bình phương của a và b là: "+x11);
		System.out.println("Giá trị gần nhất của a là: "+x12);
		System.out.println("Sin của a là: "+x13);
		System.out.println("Tang của a là: "+x14);
		System.out.println("Góc của a là: "+x15);
		System.out.println("Số radian của góc a là "+x16);
		System.out.println("Số dấu phẩy động bên cạnh đối số đầu tiên theo hướng của đối số 2 của a là: "+x17);
		System.out.println("Cosin của a là: "+x18);
		System.out.println("Cosin hyperbol của a là: "+x19);
		System.out.println("Sin hyperbol của a là: "+x20);	
	}

}
