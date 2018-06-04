package hello;

import java.util.Scanner;

public class sosanh {
	public static void main(String[] args) {
		int a, b, c, d, e;
		Scanner input = new Scanner(System.in);
		System .out.println("Nhập giá trị a =");
		a = input.nextInt();
		System.out.println("Nhập giá trị b = ");
		b = input.nextInt();
		System.out.println("Nhập giá trị c = ");
		c = input.nextInt();
		
		d = Math.min(a, Math.min(c, b));
		e = Math.max(a, Math.max(c, b));
		System.out.println("Số nhỏ nhất trong 3 số là :" +d);
		System.out.println("Số lớn nhất trong 3 số là :" +e);
	}

}