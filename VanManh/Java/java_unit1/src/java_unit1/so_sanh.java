package java_unit1;
import java.util.Scanner;

public class so_sanh {
	public static void main (String [] agrs) {
		int a,b,c,x,y;
		//Nhập giá trị từ bàn phím
		Scanner input = new Scanner(System.in);
		
		System.out.print("Nhập giá trị a=");
		a= input.nextInt();
		
		System.out.print("Nhập giá trị b=");
		b=input.nextInt();
		
		System.out.print("Nhập giá trị c=");
		c=input.nextInt();
		
		//Tìm số nhỏ nhất
		x = Math.min(a, Math.min(c, b));
		//Tìm số lớn nhất
		y = Math.max(a, Math.max(c, b));
		
		//In ra giá trị lớn nhất và nhỏ nhất
		System.out.println("Giá trị nhỏ nhất là :"+ x);
		System.out.println("Giá trị lớn nhất là :"+ y);
	}
}

